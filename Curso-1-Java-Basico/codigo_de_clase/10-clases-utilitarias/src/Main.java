import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Probando Clase Utilitaria Math
        System.out.println(">>>ABS");
        System.out.println(Math.abs(5));
        System.out.println(Math.abs(-5));

        System.out.println(">>>POW");
        System.out.println(Math.pow(2, 3));

        // Probando Clase Utilitaria Arrays
        System.out.println(">>>SORT");
        int[] numeros = {5, 2, 9, 1, 7};
        Arrays.sort(numeros);
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        // Probando Clase MiClaseUtilitaria
        System.out.println("\n>>>SUMA");
        System.out.println(MiClaseUtilitaria.suma(5, 3));

        System.out.println(">>>RESTA");
        System.out.println(MiClaseUtilitaria.resta(5, 3));
    }
}