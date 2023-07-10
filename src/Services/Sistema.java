package Services;

import Model.Libros;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Sistema {

    void leerUsuarios() ;
    void leerLibros() ;
    void actualizarArchivo(List<Libros> listaLibros) throws IOException;
}
