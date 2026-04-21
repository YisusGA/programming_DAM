package model;

import java.io.Serializable;
import java.util.Objects;

public class Prestamo implements Serializable {

    // Se recomienda incluir este campo al implementar Serializable
    // para mantener la compatibilidad entre distintas versiones de la clase.
    private static final long serialVersionUID = 1L;

    private int idPrestamo;
    private String dniUsuario;
    private String isbnLibro;
    private boolean devuelto;

    // Constructor por defecto (vacío)
    public Prestamo() {
    }

    // Constructor con todos los parámetros
    public Prestamo(int idPrestamo, String dniUsuario, String isbnLibro, boolean devuelto) {
        this.idPrestamo = idPrestamo;
        this.dniUsuario = dniUsuario;
        this.isbnLibro = isbnLibro;
        this.devuelto = devuelto;
    }

    // Getters
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    // Setters
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    // El ID del préstamo es el identificador único ideal para equals() y hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return idPrestamo == prestamo.idPrestamo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPrestamo);
    }

    // Método toString() para mostrar la información del préstamo fácilmente
    @Override
    public String toString() {
        return "Prestamo{" +
                "ID=" + idPrestamo +
                ", DNI='" + dniUsuario + '\'' +
                ", ISBN='" + isbnLibro + '\'' +
                ", Devuelto=" + (devuelto ? "Sí" : "No") +
                '}';
    }
}