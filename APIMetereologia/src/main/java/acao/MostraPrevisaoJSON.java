package acao;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostraPrevisaoJSON implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String previsoes = request.getParameter("previsoes");
        Gson gson = new Gson();
        String json = gson.toJson(previsoes);
        response.setContentType("application/json");
        response.getWriter().print(json);
        return null;
    }
}
