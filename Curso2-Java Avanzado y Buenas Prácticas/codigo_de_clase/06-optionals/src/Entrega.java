import java.util.Optional;

public class Entrega {
    public String verificarDireccion(Optional<String> direccion){
        return direccion
                .map(dir -> "Entrega programada para: " + dir)
                .orElse("Dirección no disponible. Por favor, proporciónala antes del envío.");
    }
}
