package modelo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamImplicitCollection;

import java.util.ArrayList;
import java.util.List;
@XStreamAlias("cidades")
public class Cidades {
    private List<Cidade> cidade  = new ArrayList<Cidade>();

    @Override
    public String toString() {
        return "Cidades{" +
                "cidade=" + cidade +
                '}';
    }

    public List<Cidade> getCidade() {
        return cidade;
    }
}
