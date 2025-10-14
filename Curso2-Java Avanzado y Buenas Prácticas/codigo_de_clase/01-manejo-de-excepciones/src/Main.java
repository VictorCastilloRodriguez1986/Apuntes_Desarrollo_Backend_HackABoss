import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Sistema de apuestas: Validar que la edad del usuario sea mayor a 18.
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese su edad: ");
        int edad = s.nextInt();

        try {
            if (edad < 18) throw new EdadInvalidaException("No tienes edad suficiente para apostar.");
        } catch (EdadInvalidaException e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        //Sistema de gestión de entradas: No se pueden reservar más de 5 entradas por persona.
        System.out.print("Ingrese cantidad de entradas a reservar: ");
        int cantidad = s.nextInt();

        try {
            reservarEntradas(cantidad);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void reservarEntradas(int cantidad) throws Exception {
        if (cantidad > 5) throw new Exception("No puedes reservar más de 5 entradas.");
        System.out.println("Reserva confirmada para " + cantidad + " entradas.");
    }
}