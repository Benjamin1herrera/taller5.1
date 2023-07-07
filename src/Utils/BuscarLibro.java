package Utils;

import Model.Libros;
import Model.Usuario;

import javax.swing.*;
import java.util.List;

public class BuscarLibro extends JFrame {
    private JButton buscarButton;
    private JPanel panelBuscar;
    private JTextField textField1;
    private JTextArea textArea1;
    private List<Usuario> listaUsuario;
    private List<Libros> listaLibros;

    public BuscarLibro(List<Usuario> listaUsuario, List<Libros> listaLibros){
        this.listaLibros = listaLibros;
        this.listaUsuario = listaUsuario;
        setContentPane(panelBuscar);
        setTitle("Busqueda de libro");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
