package model;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Libro  {

    private String isbn;
    private String titulo;
    private List<String> autores; 
    private int anioPublicacion;
    private String genero;
    private String estante;
    private double precioSugerido;

    // Constructor vacío 
    public Libro() {
    }

    // Constructor con todos los parámetros
    public Libro(String isbn, String titulo, List<String> autores, int anioPublicacion, 
                 String genero, String estante, double precioSugerido) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = autores;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.estante = estante;
        this.precioSugerido = precioSugerido;
    }

    // Getters
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public List<String> getAutores() { return autores; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public String getGenero() { return genero; }
    public String getEstante() { return estante; }
    public double getPrecioSugerido() { return precioSugerido; }

    // Setters
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutores(List<String> autores) { this.autores = autores; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setEstante(String estante) { this.estante = estante; }
    public void setPrecioSugerido(double precioSugerido) { this.precioSugerido = precioSugerido; }

  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }


    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + isbn + '\'' +
                ", Titulo='" + titulo + '\'' +
                ", Autores=" + autores +
                ", Año=" + anioPublicacion +
                ", Genero='" + genero + '\'' +
                ", Estante='" + estante + '\'' +
                ", Precio=" + precioSugerido +
                '}';
    }
}