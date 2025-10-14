public class Main {
    public static void main(String[] args) {
        int temperatura = 30;
        int[] notas = {10, 8, 9};
        int contador = 0;
        int numero = 123;
        String texto = "123";

        /*************** If-Else con llaves ***************/
        if (temperatura > 24) {
            System.out.println("Encender el AA");
        } else {
            System.out.println("Apagar el AA");
        }

        /*************** If-Else sin llaves ***************/
        if (temperatura > 24) System.out.println("Encender el AA");
        else System.out.println("Apagar el AA");

        /****************** Ternario *********************/
        System.out.println(temperatura > 24 ? "Encender el AA" : "Apagar el AA");

        /******************** For ***********************/
        for (int i = 0; i < notas.length; i++) {
            System.out.println("La nota " + (i+1) + " es: " + notas[i]);
        }

        /***************** For-Each ********************/
        for(int nota : notas){
            contador++;
            System.out.println("La nota " + contador + " es: " + nota);
        }

        /***************** Casting ********************/
        // Convertir Número a Texto
        String numeroTexto = Integer.toString(numero);
        System.out.println("Texto en número: " + numeroTexto);

        // Convertir Texto a Número
        int textoNumero = Integer.parseInt(texto);
        System.out.println("Número en texto: " + textoNumero);
    }
}