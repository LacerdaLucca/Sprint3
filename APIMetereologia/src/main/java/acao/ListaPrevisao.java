package acao;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import modelo.Cidade;
import modelo.Cidades;
import modelo.Previsao;
import modelo.PrevisaoCidade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.Normalizer;
import java.util.Locale;


public class ListaPrevisao implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = String.valueOf(request.getParameter("nome"));
        String uf = String.valueOf(request.getParameter("uf"));
        PrevisaoCidade previsao = BuscaTemperatura(BuscaIdCidade(nome,uf));
        System.out.println(previsao.getPrevisao());
        Gson gson = new Gson();
        String json = gson.toJson(previsao);
        response.setContentType("application/json");
        response.getWriter().print(json);
        request.setAttribute("previsoes", previsao.getPrevisao());
        return null;
    }

    private PrevisaoCidade BuscaTemperatura(int id) {
        Client client = ClientBuilder.newClient();
        String strTarget = "http://servicos.cptec.inpe.br/XML/cidade/7dias/"+id+"/previsao.xml";
        WebTarget target = client.target(strTarget);
        String conteudo = target.path("").request().get(String.class);
        System.out.println(conteudo);
        XStream xstream = new XStream();
        String dateFormat = "yyyy-MM-dd";
        String[] acceptableFormats = {"yyyy-MM-dd"};
        xstream.registerConverter(new DateConverter(dateFormat, acceptableFormats));
        xstream.registerConverter(new DateConverter(null, null));
        xstream.alias("cidade",PrevisaoCidade.class);
        xstream.addImplicitCollection(PrevisaoCidade.class,"previsao", Previsao.class);
        PrevisaoCidade pc = (PrevisaoCidade)xstream.fromXML(conteudo);
        return pc;
    }

    private int BuscaIdCidade(String nome, String uf) {
        int id = 0;
        System.out.println("Busca");
        nome = Normalizer.normalize(nome, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        String nomeURL = nome.replace(" ","%20");
        HttpClient client = HttpClient.newHttpClient();
        String strTarget = "http://servicos.cptec.inpe.br/XML/listaCidades?city=";
        strTarget+=nomeURL;
        var request = HttpRequest.newBuilder(
                        URI.create(strTarget))
                .header("accept", "application/xml")
                .build();
        HttpResponse<String> conteudo = null;
        try {
            conteudo = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(conteudo.body());
        XStream xstream = new XStream();
        xstream.alias("cidades",Cidades.class);
        xstream.addImplicitCollection(Cidades.class,"cidade",Cidade.class);
        Cidades cidades = (Cidades)xstream.fromXML(conteudo.body());
        for (Cidade cidade:cidades.getCidade()) {
            String nomeCidade = cidade.getNome().replace("'","").toLowerCase();
            nomeCidade = Normalizer.normalize(nomeCidade, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            System.out.println(nomeCidade+ " " + nome);
            String ufCidade = cidade.getUf().replace("'","");
            if(nomeCidade.equals(nome.toLowerCase()) && ufCidade.equals(uf.toUpperCase())){
                id = cidade.getId();
            }
        }
        return id;
    }
}
