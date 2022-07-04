package loja.modelo.Compras;

import loja.modelo.Compras.Compra;

import java.util.Date;

public class NovaCompra {
    private static Compra compra = new Compra();

    public static Compra getCompra() {
        return compra;
    }

    public static void calculaValores() {
        compra.setValorCompra();
        compra.setValorFrete();
        compra.setDiaEntrega();
    }

    public static void reset() {
        compra = new Compra();
    }
}
