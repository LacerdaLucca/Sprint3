package acao;

import com.thoughtworks.xstream.XStream;
import modelo.PrevisaoCidade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.io.IOException;

public class ListaPrevisao implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = String.valueOf(request.getParameter("nome"));
        String uf = String.valueOf(request.getParameter("uf"));
        PrevisaoCidade previsao = BuscaTemperatura(BuscaIdCidade(nome,uf));
        System.out.println(nome + " " + uf);
        request.setAttribute("previsoes", previsao.getPrevisao());
        return "forward:lista.jsp";
    }

    private PrevisaoCidade BuscaTemperatura(int id) {
        PrevisaoCidade previsaoCidade = new PrevisaoCidade();
        Client client = ClientBuilder.newClient();
        String strTarget = "http://servicos.cptec.inpe.br/XML/cidade/"+id+"/previsao.xml";
        WebTarget target = client.target(strTarget);
        String conteudo = target.path("").request().get(String.class);
        System.out.println(conteudo);
//        PrevisaoCidade pc = (PrevisaoCidade)(new XStream()).fromXML(conteudo);
//        System.out.println(pc);

        return previsaoCidade;
    }

    private int BuscaIdCidade(String nome, String uf) {
        System.out.println("Busca");
        Client client = ClientBuilder.newClient();
        String strTarget = "http://servicos.cptec.inpe.br/XML/listaCidades?city=";
        strTarget+=nome;
        WebTarget target = client.target(strTarget);
        String conteudo = target.path("").request().get(String.class);
        System.out.println(conteudo);
//        Object cidades = (new XStream()).fromXML(conteudo);
//        System.out.println(cidades);
        return 222;
    }
}
