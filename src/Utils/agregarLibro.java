package Utils;

import Model.Libros;
import Model.Usuario;
import Services.SistemaImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class agregarLibro extends JFrame {
    private JPanel registerForm;
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

    public agregarLibro(List<Usuario> listaUsuario, List<Libros> listaLibros) {
        this.listaUsuario = listaUsuario;
        this.listaLibros = listaLibros;
        setContentPane(agregarPanel);
        setTitle("Agregar Libro");
        setSize(600, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregar(listaUsuario, listaLibros);
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    volver(listaLibros, listaUsuario);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void agregar(List<Usuario> listaUsuario, List<Libros> listaLibros) {
        boolean condicion = true;
        try {
            String isbnIngresado = isbnInicial.getText();
            String tituloIngresado = tituloInicial.getText();
            String autorIngresado = autorInicial.getText();
            String categoriaIngresada = categoriaInicial.getText();
            String copiasIngresada = copiasInicial.getText();
            String precioIngresado = precioInicial.getText();
            Iterator<Libros> iterator = this.listaLibros.iterator();

            if (!isbnIngresado.isEmpty() && !tituloIngresado.isEmpty() && !autorIngresado.isEmpty() && !categoriaIngresada.isEmpty() && !copiasIngresada.isEmpty() && !precioIngresado.isEmpty()) {
                while (iterator.hasNext()) {
                    Libros libros = iterator.next();
                    String isbn = libros.getIsbn();
                    if (isbnIngresado.equalsIgnoreCase(isbn)) {
                        condicion = false;
                        JOptionPane.showMessageDialog(registerForm, "Este libro ya existe");
                        clear();
                    }
                }
                if (condicion){
                    int copias = Integer.parseInt(copiasIngresada);
                    int precio = Integer.parseInt(precioIngresado);
                    Libros libroAgregar = new Libros(isbnIngresado,tituloIngresado,autorIngresado,categoriaIngresada,copias,precio);
                    listaLibros.add(libroAgregar);
                    JOptionPane.showMessageDialog(registerForm,"Libro agregado");
                    clear();
                }
            }else{
                JOptionPane.showMessageDialog(registerForm, "Por favor tiene que rellenar todos los campos");
                clear();
            }
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(registerForm, "[!] Ha ocurrido un error");
            clear();
        }
    }

    private void clear() {
        isbnInicial.setText("");
        tituloInicial.setText("");
        autorInicial.setText("");
        categoriaInicial.setText("");
        copiasInicial.setText("");
        precioInicial.setText("");
    }

    private void volver(List<Libros> listaLibros, List<Usuario> listaUsuario) throws IOException {
        menuPrincipal menuPrincipal = new menuPrincipal(listaUsuario,listaLibros);
        SistemaImpl sistemaImpls = new SistemaImpl();
        sistemaImpls.actualizarArchivo(listaLibros);
        dispose();
        agregarPanel.setVisible(false);
        menuPrincipal.setVisible(true);
    }
}
