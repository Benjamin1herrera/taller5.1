package Model;

public class Libros {
    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;
    private int copias;
    private int precio;

    public Libros(String isbn, String titulo, String autor, String categoria, int copias, int precio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.copias = copias;
        this.precio = precio;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCopias() {
        return copias;
    }

    public int getPrecio() {
        return precio;
    }
}
