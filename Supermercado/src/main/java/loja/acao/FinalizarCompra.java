package loja.acao;

import loja.modelo.Compras.NovaCompra;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FinalizarCompra implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NovaCompra.calculaValores();
        request.setAttribute("compra",NovaCompra.getCompra());
        return "forward:finalizaCompra.jsp";
    }
}
