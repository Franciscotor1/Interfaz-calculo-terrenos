public class Terreno {
    private double ancho;
    private double largo;

    public Terreno(double ancho, double largo) {
        this.ancho = ancho;
        this.largo = largo;
    }

    public double calcularPerimetro() {
        return 2 * (ancho + largo);
    }

    public double calcularArea() {
        return ancho * largo;
    }

    public double calcularCantidadSemilla(double densidadSemilla) {
        return densidadSemilla * calcularArea();
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }
}
