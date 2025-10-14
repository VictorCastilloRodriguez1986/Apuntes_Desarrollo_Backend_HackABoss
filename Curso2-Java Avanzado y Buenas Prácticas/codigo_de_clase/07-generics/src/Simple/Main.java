package Simple;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();

        List<String> mensajes = List.of("Inicio", "Conexión", "Cierre");
        List<Integer> codigos = List.of(100, 200, 400);

        monitor.monitorearItems(mensajes);
        monitor.monitorearItems(codigos);
    }
}
