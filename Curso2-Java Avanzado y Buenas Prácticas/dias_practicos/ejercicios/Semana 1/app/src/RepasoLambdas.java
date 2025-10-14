import java.util.List;

public class RepasoLambdas {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1,2,3,4,77,88);

        // Quiero filtrar los números pares

        // Ver. extensa
        numeros.stream().filter(n -> {   // [2,4,88]
            // cuerpo de la función lambda
            if(n%2 == 0){
                // quiero el numero, es par
                return true;
            }
            // no lo quiero, es impar
            return false;
        }).forEach(n -> System.out.println(n));

        System.out.println("\n------------------");

        // Mejora 1 - return comparación y referencia a método
        numeros.stream().filter(n -> {
            // cuerpo de la función lambda
            return n%2 == 0;
        }).forEach(System.out::println); // n -> System.out.println(n)

        // Mejora 2 - return implicito
        numeros.stream().filter(n -> n%2 == 0).forEach(System.out::println); // n -> System.out.println(n)
    }
}