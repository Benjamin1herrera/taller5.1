package Utils;

import Model.Libros;
import Model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class menuPrincipal extends JFrame {
    private JButton devolverLibroButton;
    private JPanel menuPrincipal;
    private JButton buscarLibroButton;
    private JButton agregarNuevoLibroButton;
    private JButton prestarLibroButton;
    private JButton cerrarSesionButton;
    private List<Usuario> listaUsuario;
    private List<Libros> listaLibros;

    public menuPrincipal(List<Usuario> listaUsuario, List<Libros> listaLibros){
        this.listaLibros = listaLibros;
        this.listaUsuario = listaUsuario;
        setContentPane(menuPrincipal);
        setTitle("Menu Principal");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {busquedaLibro(listaUsuario,listaLibros);
            }
        });
        prestarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        agregarNuevoLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        devolverLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrar(listaUsuario,listaLibros);

            }
        });
    }

    private void cerrar(List<Usuario> listaUsuario, List<Libros> listaLibros) {
        IniciarSesion sesion = new IniciarSesion(listaUsuario,listaLibros);
        dispose();
        menuPrincipal.setVisible(false);
        sesion.setVisible(true);
    }


    private void busquedaLibro(List<Usuario> listaUsuario, List<Libros> listaLibros) {
        BuscarLibro buscarLibro = new BuscarLibro(listaUsuario,listaLibros);
        dispose();
        menuPrincipal.setVisible(false);
        buscarLibro.setVisible(true);

    }
}
