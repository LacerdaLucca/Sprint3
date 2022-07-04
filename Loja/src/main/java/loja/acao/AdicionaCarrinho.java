package loja.acao;

import loja.modelo.Compras.Compra;
import loja.modelo.Compras.NovaCompra;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdicionaCarrinho implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NovaCompra.getCompra().setProdutoCarrinho(id);
        System.out.println(NovaCompra.getCompra().getCarrinho());
        return "redirect:entrada?acao=NovaCompraForm";
    }

}
