import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        /***************************************************************************************************************
         * Crea una función que reciba un nombre en forma de String y devuelva su versión en mayúsculas utilizando Optional.
         * Si el nombre recibido es null, debe devolver "INVITADO" como valor por defecto.
         * Además, si el nombre tiene más de 10 caracteres, imprime un mensaje indicando que es "un nombre largo".
         * Ayuda:
         * - Envolver el valor potencialmente nulo con Optional.ofNullable()
         * - Utilizar map() para transformar un valor si está presente
         * - Aplicar orElse() para retornar un valor alternativo si el original no existe
         * - Usar ifPresent() para ejecutar una acción condicional
         **************************************************************************************************************/
        System.out.println(procesarNombre("Valentina")); // VALENTINA
        System.out.println(procesarNombre(null)); // INVITADO
        System.out.println(procesarNombre("Maximiliano")); // MAXIMILIANO + mensaje

        /***************************************************************************************************************
         * Ejercicio 2: Confirmación de número de teléfono en una aplicación
         * Estás desarrollando una app de mensajería. Cuando un usuario se registra, puede (o no) ingresar su número de
         * teléfono. Quieres crear un metodo que:
         * - Reciba un Optional con el número.
         * - Si lo ingresó, mostrar: "Número registrado: [número]"
         * - Si no lo hizo, mostrar: "No se ha registrado un número de teléfono."
         **************************************************************************************************************/
        Registro r = new Registro();
        System.out.println(r.verificarTelefono(Optional.of("+34 600 123 456")));
        System.out.println(r.verificarTelefono(Optional.empty()));

        /***************************************************************************************************************
         * Ejercicio 3: Dirección de entrega opcional
         * Estás creando una app de compras online. Algunos usuarios eligen guardar su dirección de entrega, otros
         * prefieren ingresarla después. Escribe un metodo que:
         * - Reciba un Optional con la dirección guardada.
         * - Si hay dirección, devuelva: "Entrega programada para: [dirección]"
         * - Si no hay dirección, devuelva: "Dirección no disponible. Por favor, proporciónala antes del envío."
         **************************************************************************************************************/
        Entrega app = new Entrega();
        System.out.println(app.verificarDireccion(Optional.of("Calle Luna 123, Madrid")));
        System.out.println(app.verificarDireccion(Optional.empty()));
    }

    private static String procesarNombre(String nombre) {
        Optional<String> nompreOpt = Optional.ofNullable(nombre);

        nompreOpt
                .filter(n -> n.length() > 10)
                .ifPresent(n -> System.out.println("Es un nombre largo."));

        return nompreOpt
                .map(String::toUpperCase)
                .orElse("INVITADO");
    }
}