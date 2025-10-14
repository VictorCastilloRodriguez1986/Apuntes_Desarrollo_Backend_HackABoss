import Enums.Estado;
import Enums.Rol;

public class Main {
    public static void main(String[] args) {
        /******************************************************
         *                       Interfaces                   *
         *****************************************************/
        Coche miCoche = new Coche();
        miCoche.acelerar();
        miCoche.conectarWifi();

        /******************************************************
         *                Clases Abstractas                   *
         *****************************************************/
        Vehiculo v1 = new Automovil();
        Vehiculo v2 = new Bicicleta();
        Vehiculo v3 = new Patinete();

        v1.avanzar();
        v2.avanzar();
        v3.avanzar();

        /******************************************************
         *                        Enums                       *
         *****************************************************/
        // Sin parámetros ni métodos
        Rol usuario = Rol.ADMIN;
        System.out.println("El rol del usuario es: " + usuario);

        // Con parámetros y métodos
        Estado estado = Estado.ENVIADO;
        System.out.println("Estado: " + estado);
        System.out.println("Descripción: " + estado.getDescripcion());
    }
}