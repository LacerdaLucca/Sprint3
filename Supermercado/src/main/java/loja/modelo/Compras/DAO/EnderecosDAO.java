package loja.modelo.Compras.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EnderecosDAO {
    private Connection connection;
    public EnderecosDAO(Connection connection){
        this.connection = connection;
    }
    public double calculaFrete(String endereco) {
        double preco = 0;
        endereco = endereco.toLowerCase();
        String[] dados = endereco.split(",");
        String comando = "SELECT PRECO FROM FRETES WHERE CIDADE = ? AND UF = ?";
        try (PreparedStatement pstm = connection.prepareStatement(comando)) {
            pstm.setString(1, dados[3]);
            pstm.setString(2, dados[4]);
            pstm.execute();
            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    System.out.println("RST " + rst.getDouble(1));
                    preco = rst.getDouble(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return preco;
    }

    public Date calculaDiaEntrega(String endereco) {
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

        String[] dados = endereco.split(",");
        String comando = "SELECT TEMPO FROM FRETES WHERE CIDADE = ? AND UF = ?";

        try (PreparedStatement pstm = connection.prepareStatement(comando)) {
            pstm.setString(1, dados[3]);
            pstm.setString(2, dados[4]);
            pstm.execute();
            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    data.setDate(rst.getInt(1) + data.getDate());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
