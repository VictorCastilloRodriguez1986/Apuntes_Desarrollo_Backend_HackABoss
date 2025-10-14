import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    // Dada una lista de enteros
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);

        imprimir(numeros);

    // 1. Filtrar los números pares
        List<Integer> pares = new ArrayList<>();
        for(int numero : numeros){
            if(numero % 2 == 0){
                pares.add(numero);
            }
        }

        imprimir(pares);

    // 2. Multiplicarlos x2
        List<Integer> x2 = new ArrayList<>();
        for (int par : pares){
            x2.add(par*2);
        }

        imprimir(x2);

    // 3. Sumar el resultado final
        int resultado = 0;
        for (int x : x2){
            resultado += x;
        }

        System.out.println("Resultado: " + resultado);
    }

    private static void imprimir(List<Integer> lista) {
        for (int elemento : lista){
            System.out.print(elemento + " ");
        }

        System.out.println("\n------------");
    }
}