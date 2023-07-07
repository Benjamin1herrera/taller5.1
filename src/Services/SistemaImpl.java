package Services;

import Model.Libros;
import Model.Usuario;
import Utils.IniciarSesion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SistemaImpl implements Sistema {
    ArrayList <Usuario> listaUsuarios = new ArrayList<>();
    ArrayList <Libros>  listaLibros = new ArrayList<>();
    private IniciarSesion iniciarSesion;

    public SistemaImpl() throws IOException {
        this.leerLibros();
        this.leerUsuarios();

    }

    @Override
    public void leerLibros() throws IOException {
        // Leer el archivo "libros.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] chain = line.split(",");
                String isbn = chain[0];
                String title = chain[1];
                String author = chain[2];
                String category = chain[3];
                int copies = Integer.parseInt(chain[4]);
                int price = Integer.parseInt(chain[5]);

                //TODO: Guardar el libro en algúna estructura de datos.
                Libros libro = new Libros(isbn, title, author, category, copies, price);
                listaLibros.add(libro);

            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }

    @Override
    public void leerUsuarios() throws IOException {
        // Leer el archivo "usuarios.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Usuario usuario;
                String[] chain = line.split(",");
                String rut = chain[0];
                String name = chain[1];
                String lastname = chain[2];
                String password = chain[3];

                //TODO: Guardar el usuario en algúna estructura de datos.
                Usuario usuario1 = new Usuario(rut, name, lastname, password);
                listaUsuarios.add(usuario1);
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error "+e.getMessage());
        }
    }

    public void iniciar() throws IOException {
        this.iniciarSesion = new IniciarSesion(listaUsuarios,listaLibros);
    }
}

