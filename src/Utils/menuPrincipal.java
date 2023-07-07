package Utils;

import Model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class menuPrincipal extends JFrame {
    private JButton devolverLibroButton;
    private JPanel menuPrincipal;
    private JButton buscarLibroButton;
    private JButton agregarNuevoLibroButton;
    private JButton prestarLibroButton;

    private List<Usuario> listaUsuario;

    public menuPrincipal(List<Usuario> listaUsuario){
        setContentPane(menuPrincipal);
        setTitle("Menu Principal");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
    }
}
