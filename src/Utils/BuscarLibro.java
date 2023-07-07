package Utils;

import Model.Libros;
import Model.Usuario;

import javax.swing.*;
import java.util.List;

public class BuscarLibro extends JFrame {

    private List<Usuario> listaUsuario;
    private List<Libros> listaLibros;
    private JButton buscarButton;
    private JPanel buscar;
    private JTextField textField1;
    private JButton volverButton;
    private JLabel impresion;

    public BuscarLibro(List<Usuario> listaUsuario, List<Libros> listaLibros) {
        this.listaLibros = listaLibros;
        this.listaUsuario = listaUsuario;
        setContentPane(buscar);
        setTitle("Busqueda de libro");
        setSize(450, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
