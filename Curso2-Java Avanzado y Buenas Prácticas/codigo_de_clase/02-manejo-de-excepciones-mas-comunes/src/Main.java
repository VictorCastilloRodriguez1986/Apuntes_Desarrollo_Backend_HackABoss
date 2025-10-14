import java.io.IOException;
import java.util.Scanner;
/********************************************
 * 🎮 Escape Room Java
 * Solución esperada (lógica):
 * Puerta 1 → lanza NullPointerException
 * Puerta 2 → lanza IOException
 * Puerta 3 → no lanza ninguna → ¡la correcta!
 ********************************************/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🕵️ Te despiertas en una habitación con 3 puertas.");
        System.out.println("Una te libera. Las otras… no tanto.");
        System.out.print("¿Qué puerta eliges (1, 2 o 3)? ");
        int eleccion = sc.nextInt();

        try {
            switch (eleccion) {
                case 1 -> puertaUno();
                case 2 -> puertaDos();
                case 3 -> puertaTres();
                default -> System.out.println("❓ Esa puerta no existe. ¡Te has perdido en los pasillos!");
            }
        } catch (NullPointerException e) {
            System.out.println("💀 Puerta 1: Has caído en la trampa del olvido (NullPointerException).");
        } catch (IOException e) {
            System.out.println("🔒 Puerta 2: " + e.getMessage());
        } finally {
            System.out.println("🔚 Juego terminado. Reinicia para volver a intentarlo.");
            sc.close();
        }
    }

    public static void puertaUno() {
        String mensaje = null;
        System.out.println(mensaje.length()); // NullPointerException
    }

    public static void puertaDos() throws IOException {
        throw new IOException("¡Puerta bloqueada! Necesitas una tarjeta magnética.");
    }

    public static void puertaTres() {
        System.out.println("✅ ¡Has elegido la puerta correcta y escapaste con éxito!");
    }
}