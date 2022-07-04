package loja.acao;

import com.google.gson.Gson;
import loja.modelo.Compras.Compra;
import loja.modelo.Compras.NovaCompra;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FinalizarCompraJSON implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Compra c = NovaCompra.getCompra();
        Gson gson = new Gson();
        String json = gson.toJson(c);

        response.setContentType("application/json");
        response.getWriter().print(json);
        return null;
    }
}
