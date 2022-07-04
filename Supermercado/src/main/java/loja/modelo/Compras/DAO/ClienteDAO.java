package loja.modelo.Compras.DAO;

import loja.modelo.Compras.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;
    public ClienteDAO(Connection connection){
        this.connection = connection;
    }

    public void adiciona(Cliente cliente){

        String comando = "INSERT INTO CLIENTES (NOME, SENHA, CPF, ENDERECO) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstm = connection.prepareStatement(comando)){

            pstm.setString(1,cliente.getNome());
            pstm.setString(2,cliente.getSenha());
            pstm.setString(3,cliente.getCPF());
            pstm.setString(4,cliente.getEndereco());

            pstm.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void remove(String cpf){
        try (PreparedStatement pstm = connection.prepareStatement("DELETE FROM CLIENTES WHERE CPF = ?")){
            pstm.setString(1,cpf);
            pstm.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualiza(Cliente cliente){
        try (PreparedStatement pstm = connection
                .prepareStatement("UPDATE CLIENTES C SET C.NOME = ?, C.SENHA = ?, C.ENDERECO = ? WHERE CPF = ?")) {
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getSenha());
            pstm.setString(3, cliente.getEndereco());
            pstm.setString(4, cliente.getCPF());
            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> lista(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        String comando = "SELECT * FROM CLIENTES";
        try (PreparedStatement pstm = connection.prepareStatement(comando)){
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Cliente cliente = new Cliente(rst.getString(1),rst.getString(2), rst.getString(3),
                            rst.getString(4));
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }

    public Cliente busca(String cpf, String senha) {
        Cliente cliente = null;
        try (PreparedStatement pstm = connection.prepareStatement("SELECT * FROM CLIENTES WHERE CPF = ? AND SENHA = ?")) {
            pstm.setString(1, cpf);
            pstm.setString(2, senha);
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    cliente = new Cliente(rst.getString(1),rst.getString(2), rst.getString(3),
                            rst.getString(4));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

}
