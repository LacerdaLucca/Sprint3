package modelo;


import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrevisaoCidade {
    @XStreamImplicit(itemFieldName = "nome")
    private String nome;
    @XStreamImplicit(itemFieldName = "uf")
    private String uf;
    @XStreamImplicit(itemFieldName = "atualizacao")
    private String atualizacao;
    private List<Previsao> previsao = new ArrayList<Previsao>();

    public List<Previsao> getPrevisao() {
        return previsao;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public String getAtualizacao() {
        return atualizacao;
    }
}
