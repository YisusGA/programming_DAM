package examen_año_anterior05_ejercicio02;

public class Particula {
    int carga;
    double masa;
    Punto posicion;

    public Particula(int carga, double masa, Punto posicion) {
        this.carga = carga;
        this.masa = masa;
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Carga: " + carga + ", Masa: " + masa + ", Posición: " + posicion;
    }
}
