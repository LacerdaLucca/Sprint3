package loja.acao;

import loja.modelo.Compras.NovaCompra;
import loja.modelo.Compras.Produto;
import loja.modelo.Compras.DAO.ProdutoDAO;
import loja.modelo.Connections.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class NovaCompraForm implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = (new ConnectionFactory()).recuperarConexao();
        ProdutoDAO banco = new ProdutoDAO(connection);
        List<Produto> produtos = banco.lista();
        request.setAttribute("produtos", produtos);
        return "forward:formNovaCompra.jsp";
    }
}
