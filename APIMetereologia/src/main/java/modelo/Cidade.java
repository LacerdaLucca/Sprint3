package modelo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.extended.NamedMapConverter;
@XStreamAlias("cidade")
public class Cidade {
    @XStreamImplicit(itemFieldName = "nome")
    private String nome;
    @XStreamImplicit(itemFieldName = "uf")
    private String uf;
    @XStreamImplicit(itemFieldName = "id")
    private int id;

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                ", id=" + id +
                '}';
    }
}
