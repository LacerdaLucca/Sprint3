package loja.acao;

import loja.modelo.Compras.Cliente;
import loja.modelo.Compras.DAO.ClienteDAO;
import loja.modelo.Connections.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

public class Login implements  Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");

        Connection connection = (new ConnectionFactory()).recuperarConexao();
        ClienteDAO clienteDAO = new ClienteDAO(connection);
        Cliente cliente = clienteDAO.busca(cpf,senha);

        if(cliente != null) {
            System.out.println("Usuario existe");
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuarioLogado", cliente);
            return "redirect:entrada?acao=NovaCompraForm";
        } else {
            return "redirect:entrada?acao=LoginForm";
        }
    }
}
