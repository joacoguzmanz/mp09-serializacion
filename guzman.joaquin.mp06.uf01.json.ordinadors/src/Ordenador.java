import java.io.Serializable;

public class Ordenador implements Serializable {
    private transient int numSerie;
    private String marca;
    private String modelo;
    private int memoria; // gb
    private int discoDuro; // gb
    private String procesador;

    public Ordenador() {
    }

    public Ordenador(int numSerie, String marca, String modelo, int memoria, int discoDuro, String procesador) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.memoria = memoria;
        this.discoDuro = discoDuro;
        this.procesador = procesador;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    @Override
    public String toString() {
        return "Ordenador{" +
                "numSerie=" + numSerie +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", memoria=" + memoria +
                ", discoDuro=" + discoDuro +
                ", procesador='" + procesador + '\'' +
                '}';
    }
}
