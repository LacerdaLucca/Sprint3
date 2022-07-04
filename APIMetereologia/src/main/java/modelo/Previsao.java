package modelo;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Date;

public class Previsao {
    @XStreamImplicit(itemFieldName = "dia")
    private String dia;
    @XStreamImplicit(itemFieldName = "tempo")
    private String tempo;
    @XStreamImplicit(itemFieldName = "maxima")
    private String maxima;
    @XStreamImplicit(itemFieldName = "minima")
    private String minima;
    @XStreamImplicit(itemFieldName = "iuv")
    private String iuv;

    public String getDia() {
        return dia;
    }

    public String getTempo() {
        return tempo;
    }

    public String getMaxima() {
        return maxima;
    }

    public String getMinima() {
        return minima;
    }

    public String getIuv() {
        return iuv;
    }

    @Override
    public String toString() {
        return "Previsao{" +
                "dia='" + dia + '\'' +
                ", tempo='" + tempo + '\'' +
                ", maxima='" + maxima + '\'' +
                ", minima='" + minima + '\'' +
                ", iuv='" + iuv + '\'' +
                '}';
    }
}
