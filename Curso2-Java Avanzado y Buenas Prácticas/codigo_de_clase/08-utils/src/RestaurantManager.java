import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class RestaurantManager {
    public static void main(String[] args) {
        // 1️⃣ Horarios de reserva disponibles
        int[] horarios = {21, 19, 20, 18};
        Arrays.sort(horarios); // Ordenar los horarios

        System.out.println("🕒 Horarios disponibles: " + Arrays.toString(horarios));

        int buscarHora = 20;
        int indice = Arrays.binarySearch(horarios, buscarHora);

        if (indice >= 0) {
            System.out.println("✅ Hay una mesa disponible a las " + horarios[indice] + ":00 hs.");
        } else {
            System.out.println("❌ No hay mesas disponibles a esa hora.");
        }

        // 2️⃣ Platos del menú
        List<String> menu = Arrays.asList("Tacos", "Hamburguesa", "Ensalada", "Pizza");
        Collections.sort(menu);
        System.out.println("\n🍽️ Menú ordenado:");
        for (String plato : menu) {
            System.out.println("- " + plato);
        }

        // 3️⃣ Mensaje promocional
        String promocion = "Ven a disfrutar nuestra nueva carta de temporada";
        StringTokenizer tokenizer = new StringTokenizer(promocion, " ");

        System.out.println("\n📣 Palabras de la promoción:");
        while (tokenizer.hasMoreTokens()) {
            System.out.println("* " + tokenizer.nextToken());
        }

        // 4️⃣ Fecha y hora actual
        System.out.println("Hoy es: " + LocalDate.now());
        System.out.println("Son las " + LocalTime.now().getHour() + ":" +
                LocalTime.now().getMinute() + ":"
                + LocalTime.now().getSecond());
    }
}