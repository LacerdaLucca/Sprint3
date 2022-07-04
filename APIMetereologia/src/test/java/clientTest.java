import modelo.Cidades;
import modelo.PrevisaoCidade;
import junit.framework.TestCase;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;



public class clientTest extends TestCase {
    @Test
    public void testaBuscaCidade() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://servicos.cptec.inpe.br/XML/listaCidades?city=sao paulo");
        String conteudo = target.path("").request().get(String.class);
        System.out.println(conteudo);
        Cidades cidades = (Cidades)(new XStream()).fromXML(conteudo);
        System.out.println(cidades);

    }
    public void testaBuscaTemperatura() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://servicos.cptec.inpe.br/XML/cidade/244/previsao.xml");
        String conteudo = target.path("").request().get(String.class);
        System.out.println(conteudo);
        PrevisaoCidade pc = (PrevisaoCidade)(new XStream()).fromXML(conteudo);
        System.out.println(pc);

    }


}

