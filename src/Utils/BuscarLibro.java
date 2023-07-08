package Utils;

import Model.Libros;
import Model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class BuscarLibro extends JFrame {

    private List<Usuario> listaUsuario;
    private List<Libros> listaLibros;
    private JPanel registerForm;
    private JButton buscarButton;
    private JPanel buscar;
    private JTextField isbnIniciar;
    private JButton volverButton;
    private JTextArea impresion;

    public BuscarLibro(List<Usuario> listaUsuario, List<Libros> listaLibros) {
        this.listaLibros = listaLibros;
        this.listaUsuario = listaUsuario;
        setContentPane(buscar);
        setTitle("Busqueda de libro");
        setSize(600, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar(listaLibros,listaUsuario);}
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver(listaLibros,listaUsuario);}
        });
    }

    private void volver(List<Libros> listaLibros, List<Usuario> listaUsuario) {

        menuPrincipal menuPrincipal = new menuPrincipal(listaUsuario,listaLibros);
        dispose();
        buscar.setVisible(false);
        menuPrincipal.setVisible(true);
    }

    private void buscar(List<Libros> listaLibros, List<Usuario> listaUsuario) {
        boolean condicion = true;
        try {
            String isbnIngresado = isbnIniciar.getText();
            Iterator<Libros> iterator = this.listaLibros.iterator();
            if (!isbnIngresado.isEmpty()){
                while (iterator.hasNext()){
                    Libros libros = iterator.next();
                    String isbn = libros.getIsbn();
                    if (isbnIngresado.equalsIgnoreCase(isbn)){
                        impresion.setText("""
                                Titulo:\s""" + libros.getTitulo() + """
                             
                                 Autor:\s""" + libros.getAutor() + """
                                 
                                  Categoria:\s""" + libros.getCategoria() + """
                                   
                                   N° de copias:\s""" + libros.getCopias() + """
                                    
                                    Precio:\s""" + libros.getPrecio() + """
                                """);
                        condicion = false;
                    }
                }
                if (condicion){
                    JOptionPane.showMessageDialog(registerForm, "no se escontro el libro");
                    clear();
                }
            }else{
                JOptionPane.showMessageDialog(registerForm, "Por favor tiene que rellenar ambos campos");
            }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(registerForm, "[!] Ha ocurrido un error");
        }
    }

    private void clear() {
        isbnIniciar.setText("");
    }
}
