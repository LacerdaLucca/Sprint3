package modelo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrevisaoCidade {

    private String nome;
    private String uf;
    private Date atualizacao;
    private List<Previsao> previsao = new ArrayList<Previsao>();

    public List<Previsao> getPrevisao() {
        return previsao;
    }


}
