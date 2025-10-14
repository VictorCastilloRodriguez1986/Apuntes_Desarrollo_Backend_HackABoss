import java.util.Optional;

public class Registro {
    public String verificarTelefono(Optional<String> numero){
        return numero
                .map(n -> "Número registrado: " + n)
                .orElse("No se ha registrado un número de teléfono.");
    }
}
