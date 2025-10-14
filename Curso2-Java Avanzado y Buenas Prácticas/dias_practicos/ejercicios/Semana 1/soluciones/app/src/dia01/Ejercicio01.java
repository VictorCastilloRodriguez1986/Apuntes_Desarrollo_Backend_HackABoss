package dia01;

import dia01.exceptions.ReservaInvalidaException;
import java.time.LocalDate;

public class Ejercicio01 {
    private static String nombre = "Stefano Peraldini";
    private static String destino;
    private static LocalDate fechaDelViaje = LocalDate.of(2025, 5, 9);
    private static Integer numeroAsientosDeseados = 4;

    private static Integer numeroAsientosQueQuedan = 3;

    public static void main(String[] args) {
        System.out.println("¡Reserva tú vuelo, solo quedan " + numeroAsientosQueQuedan + " plazas!");
        try {
            reservarAsientos(nombre, destino, fechaDelViaje, numeroAsientosDeseados);
        } catch (ReservaInvalidaException e) {
            System.err.println("Error gestionado - " + e.getMessage());
        } catch (Exception e){
            System.err.println("Error interno - " + e.getMessage());
        }
        System.out.println("Fin");
    }

    private static void reservarAsientos(String nombre, String destino, LocalDate fechaDelViaje, Integer numeroAsientosDeseados) throws ReservaInvalidaException{
        if (nombre.isBlank() || nombre == null || destino.isBlank() || destino == null || fechaDelViaje == null ||
                numeroAsientosDeseados == null || numeroAsientosDeseados <= 0 ){
            throw new ReservaInvalidaException("Todos los datos son obligatorios.");
        }

        if(fechaDelViaje.isBefore(LocalDate.now()) ){
            throw new ReservaInvalidaException("Solo puede reservar un vuelo a partir de hoy");
        }

        if (numeroAsientosDeseados > numeroAsientosQueQuedan ){
            throw new ReservaInvalidaException("Actualmente no disponemos de " + numeroAsientosDeseados + " plazas.");
        }

        System.out.println("Reserva finalizada!");
    }
}
