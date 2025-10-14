package Extends;

import java.util.List;

public class Notificador {
    public static void main(String[] args) {
        List<Admin> admins = List.of(new Admin("Ana"), new Admin("Alberto"));
        List<Cliente> clientes = List.of(new Cliente("Carlos"), new Cliente("Cintia"));

        notificarUsuarios(admins);
        notificarUsuarios(clientes);
    }

    public static void notificarUsuarios(List<? extends Usuario> usuarios){
        for (Usuario u : usuarios){
            u.enviarNotificacion("Tienens una nueva notificación.");
        }
    }
}
