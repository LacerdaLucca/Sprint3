package loja.acao;

import loja.modelo.Compras.Cliente;
import loja.modelo.Compras.DAO.ClienteDAO;
import loja.modelo.Connections.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;


public class NovoCliente implements Acao{


    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Cadastrando novo Cliente");

        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");

        Cliente cliente = new Cliente(nome,senha,cpf,endereco);
        Connection connection = (new ConnectionFactory()).recuperarConexao();
        ClienteDAO banco = new ClienteDAO(connection);
        banco.adiciona(cliente);

//        request.setAttribute("cliente", cliente.getNome());

        return "redirect:index.jsp";
    }
}
