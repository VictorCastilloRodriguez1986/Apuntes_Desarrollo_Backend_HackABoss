package dia02;

import java.util.Arrays;

import static dia02.utils.VectorUtils.aniadirElementoVector;
import static dia02.utils.VectorUtils.getElement;

public class Ejercicio01 {
    public static void main(String[] args) {
        // Defino un vettor de 4 elementos
        String[] nombres = new String[4];

        // Añado 4 elementos
        aniadirElementoVector(nombres, "Jose");
        aniadirElementoVector(nombres, "Ana");
        aniadirElementoVector(nombres, "Maria");
        aniadirElementoVector(nombres, "Antonio");

        // añado elemento que no entra
        aniadirElementoVector(nombres, "Stefano");
        // Imprimo el contenido del vector
        Arrays.stream(nombres).forEach(System.out::println);
        try {
            System.out.println("Elemento selecionado: " + getElement(nombres, 1));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("¡La posición del elemento non existe! (" + e.getMessage() + ").");
        }
        // Código ...

    }
}
