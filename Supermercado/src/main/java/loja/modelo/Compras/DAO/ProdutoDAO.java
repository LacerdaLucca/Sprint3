package loja.modelo.Compras.DAO;
import loja.modelo.Compras.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection connection;
    public ProdutoDAO(Connection connection){
        this.connection = connection;
    }

    public void adiciona(Produto produto){

        String comando = "INSERT INTO PRODUTOS (NOME, DESCRICAO, DESCONTO, PRECO, DATA_INICIO) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = connection.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS)){

            pstm.setString(1,produto.getNome());
            pstm.setString(2,produto.getDescricao());
            pstm.setDouble(3,0.0);
            pstm.setDouble(4,produto.getPreco());
            pstm.setDate(5,produto.getData());

            pstm.execute();
            try(ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    produto.setId(rst.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void adicionaID(Produto produto, int id){

        String comando = "INSERT INTO PRODUTOS (ID, NOME, DESCRICAO, DESCONTO, PRECO, DATA_INICIO) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = connection.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS)){
            pstm.setInt(1,id);
            pstm.setString(2,produto.getNome());
            pstm.setString(3,produto.getDescricao());
            pstm.setDouble(4,0.0);
            pstm.setDouble(5,produto.getPreco());
            pstm.setDate(6,produto.getData());

            pstm.execute();
            try(ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    produto.setId(rst.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void remove(int id){
        try (PreparedStatement pstm = connection.prepareStatement("DELETE FROM PRODUTOS WHERE ID = ?")){
            pstm.setInt(1,id);
            pstm.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualiza(Produto produto){
        try (PreparedStatement pstm = connection
                .prepareStatement("UPDATE PRODUTOS P SET P.NOME = ?, P.DESCRICAO = ?, P.DESCONTO= ?, P.PRECO = ?, P.DATA_INICIO = ? WHERE ID = ?")) {
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setDouble(3,0.0);
            pstm.setDouble(4,produto.getPreco());
            pstm.setDate(5,produto.getData());
            pstm.setInt(6, produto.getId());
            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produto> lista(){
        List<Produto> produtos = new ArrayList<Produto>();
        String comando = "SELECT * FROM PRODUTOS";
        try (PreparedStatement pstm = connection.prepareStatement(comando)){
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Produto produto = new Produto(rst.getInt(1),rst.getString(2), rst.getString(3),
                            rst.getDouble(5),rst.getDate(6));
                    produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }

    public Produto busca(int id) {
        Produto produto = null;
        try (PreparedStatement pstm = connection.prepareStatement("SELECT * FROM PRODUTOS WHERE ID = ?")) {
            pstm.setInt(1, id);
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    produto = new Produto(rst.getInt(1),rst.getString(2), rst.getString(3),
                            rst.getDouble(5),rst.getDate(6));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produto;
    }
}
