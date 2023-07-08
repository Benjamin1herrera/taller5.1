package Utils;

import Model.Libros;
import Model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class agregarLibro extends JFrame {
    private JTextField isbnInicial;
    private JPanel agregarPanel;
    private JTextField tituloInicial;
    private JTextField autorInicial;
    private JTextField categoriaInicial;
    private JTextField copiasInicial;
    private JTextField precioInicial;
    private JButton buscarButton;
    private JButton volverButton;
    private List<Usuario> listaUsuario;
    private List<Libros> listaLibros;

    public agregarLibro (List<Usuario> listaUsuario, List<Libros>listaLibros){
        this.listaUsuario = listaUsuario;
        this.listaLibros = listaLibros;
        setContentPane(agregarPanel);
        setTitle("Agregar Libro");
        setSize(600,450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver(listaLibros,listaUsuario);
            }
        });
    }

    private void volver(List<Libros> listaLibros, List<Usuario> listaUsuario) {
        menuPrincipal menuPrincipal = new menuPrincipal(listaUsuario,listaLibros);
        dispose();
        agregarPanel.setVisible(false);
        menuPrincipal.setVisible(true);
    }
}
