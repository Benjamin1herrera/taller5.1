package Utils;

import Model.Libros;
import Model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IniciarSesion extends JFrame {
    private JPanel registerForm;
    private JPasswordField passwordField1;
    private JTextField rutIniciar;
    private JButton iniciarSesionButton;
    private JButton salirButton;
    private JPanel panel1;
    private JLabel imagenlogo;
    private List<Usuario> listaUsuario;
    private List<Libros> listaLibros;

    public IniciarSesion(List<Usuario>listaUsuario, ArrayList<Libros> listaLibros) throws IOException {

        this.listaUsuario = listaUsuario;
        this.listaLibros = listaLibros;
        setContentPane(panel1);
        setTitle("Bienvenido a Bibliotech");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logIn(listaUsuario,listaLibros);
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

    }

    private void logIn(List<Usuario>listaUsuario, ArrayList<Libros> listaLibros) {
        boolean condicion = true;
        try {
            String rutIngresada = rutIniciar.getText();
            String contraseñaIngresada = passwordField1.getText();
            Iterator<Usuario> iterator = this.listaUsuario.iterator();
            if (!rutIngresada.isEmpty() && !contraseñaIngresada.isEmpty()) {
                while (iterator.hasNext()) {
                    Usuario usuario = iterator.next();
                    String rut = usuario.getRut();
                    String contrasenia = usuario.getContraseña();
                    System.out.println(rut);
                    if (rutIngresada.equalsIgnoreCase(rut) && contraseñaIngresada.equalsIgnoreCase(contrasenia)) {
                            condicion = false;
                            JOptionPane.showMessageDialog(registerForm, "se escontro");
                            menuPrincipal menuPrincipal = new menuPrincipal(listaUsuario,listaLibros);
                            dispose();
                            panel1.setVisible(false);
                            menuPrincipal.setVisible(true);
                    }
                }
                if(condicion){
                    JOptionPane.showMessageDialog(registerForm, "no se escontro");
                }
            }
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(registerForm, "[!] Ha ocurrido un error");
            clear();
        }
    }

    private void clear() {
        rutIniciar.setText("");
        passwordField1.setText("");

    }


    private void exit(){
        System.exit(0);
    }

}


