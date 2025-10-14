public class Main {
    public static void main(String[] args) {
        /******************************************************
         *                       Funciones                    *
         *****************************************************/
        mensaje();

        saludar("Victor");

        System.out.println(sumar(5, 10));

        System.out.println(sumar(2, 4, 6));

        int n = 9;
        int cuadrado = calcularCuadrado(n);
        System.out.println("El cuadrado de " + n + " es: " + cuadrado);

    }

    //Funciones sin parámetros ni retornos
    public static void mensaje(){
        System.out.println("Hola Mundo!");
    }

    //Funciones con parámetros
    public static void saludar(String nombre){
        System.out.println("Hola " + nombre);
    }

    //Funciones con retorno
    public static int sumar(int a, int b){
        return a + b;
    }

    //Sobrecarga de Métodos
    public static int sumar(int a, int b, int c){
        return a + b + c;
    }

    // Ejemplo: Calcular el cuadrado de un nómero
    public static int calcularCuadrado(int numero){
        int resultado = numero * numero;
        return resultado;    }
}