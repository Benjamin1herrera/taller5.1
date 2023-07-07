package Services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Sistema {

    void leerUsuarios() throws IOException;
    void leerLibros() throws IOException;
}
