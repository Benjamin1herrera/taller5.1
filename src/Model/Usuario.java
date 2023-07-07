package Model;

public class Usuario {

    private String rut;
    private String nombre;
    private String apellido;
    private String contraseña;

    public Usuario(String rut, String nombre, String apellido, String contraseña) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }
}
