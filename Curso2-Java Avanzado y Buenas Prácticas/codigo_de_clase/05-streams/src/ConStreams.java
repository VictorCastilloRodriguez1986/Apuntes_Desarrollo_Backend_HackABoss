import java.util.List;

public class ConStreams {
    public static void main(String[] args) {
        // Dada una lista de enteros
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);

        int resultado = numeros
                .stream()                          // 1. Filtrar los números pares: [1, 2, 3, 4, 5, 6]
                .filter(n -> n % 2 == 0)    // 2. Multiplicarlos x2: [2, 4, 6]
                .map(n -> n*2)              // 3. Sumar el resultado final: [4, 8, 12]
                .reduce(0, Integer::sum);   // Resultado: 24

        System.out.println(resultado);
    }
}