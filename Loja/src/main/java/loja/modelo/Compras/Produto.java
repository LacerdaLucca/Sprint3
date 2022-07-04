package loja.modelo.Compras;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Produto {
    private int id;
    private String nome, descricao, data;
    private double preco;
    public Produto(int id, String nome, String descricao, double preco, Date data){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        if(data != null)
            this.data = setData(data);
    }
    private String setData(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String resp = formato.format(data);
        return resp;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public java.sql.Date getData() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = null;
        try {
            if(this.data != null)
                data = new java.sql.Date(formato.parse(this.data).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public int getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data='" + data + '\'' +
                ", preco=" + preco +
                '}';
    }
}
