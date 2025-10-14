package Extends;

public class Usuario {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void enviarNotificacion(String mensaje){
        System.out.println("Norificando a " + nombre + ": " + mensaje);
    }
}
