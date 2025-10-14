package dia02.utils;

public class VectorUtils {
    public static void aniadirElementoVector(String[] vector, String elemento){
        // Defino una variable booleana donde guardo si el vector está lleno
        boolean lleno = true;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == null){
                vector[i] = elemento;
                lleno = false;
                // salgo del for
                break;
            }
        }
        if (lleno){
            System.err.println("¡Elemento no añadido (" + elemento + "), vector lleno!");
        }
    }

    public static String getElement(String[] vector,int posicion){
        return vector[posicion];
    }
}
