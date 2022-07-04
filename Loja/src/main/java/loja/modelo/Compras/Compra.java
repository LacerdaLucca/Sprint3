package loja.modelo.Compras;

import loja.modelo.Compras.DAO.ClienteDAO;
import loja.modelo.Compras.DAO.EnderecosDAO;
import loja.modelo.Compras.DAO.ProdutoDAO;
import loja.modelo.Connections.ConnectionFactory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
    private Cliente cliente;
    private List<Produto> carrinho = new ArrayList<Produto>();
    private double valorCompra;
    private double valorFrete;

    public double getValorCompra() {
        return valorCompra;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    private Date dataEntrega;

    public void setValorCompra() {
        double valor = 0;
        for (Produto produto : carrinho) {
             valor += produto.getPreco();
        }
        this.valorCompra = valor;
    }

    public void setValorFrete() {
        Connection connection = (new ConnectionFactory()).recuperarConexao();
        EnderecosDAO enderecosDAO = new EnderecosDAO(connection);
        ClienteDAO clienteDAO = new ClienteDAO(connection);
        cliente = clienteDAO.busca("10804592608","1111");
        this.valorFrete = enderecosDAO.calculaFrete(cliente.getEndereco());
    }

    public void setDiaEntrega() {
        Connection connection = (new ConnectionFactory()).recuperarConexao();
        EnderecosDAO enderecosDAO = new EnderecosDAO(connection);
        this.dataEntrega = enderecosDAO.calculaDiaEntrega(cliente.getEndereco());
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCarrinho(List<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    public void setProdutoCarrinho(int id) {
        Connection connection = (new ConnectionFactory()).recuperarConexao();
        ProdutoDAO banco = new ProdutoDAO(connection);
        Produto p = banco.busca(id);
        this.carrinho.add(p);

    }

    @Override
    public String toString() {
        return "Compra{" +
                "cliente=" + cliente +
                ", carrinho=" + carrinho +
                '}';
    }

}
