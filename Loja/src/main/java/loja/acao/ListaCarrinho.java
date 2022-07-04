package loja.acao;

import loja.modelo.Compras.Compra;
import loja.modelo.Compras.NovaCompra;
import loja.modelo.Compras.Produto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaCarrinho implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produto> produtos = NovaCompra.getCompra().getCarrinho();
        for (Produto produto:produtos) {
            System.out.println(produto);
        }
        System.out.println();
        request.setAttribute("produtos", produtos);
        return "forward:carrinho.jsp";
    }
}
