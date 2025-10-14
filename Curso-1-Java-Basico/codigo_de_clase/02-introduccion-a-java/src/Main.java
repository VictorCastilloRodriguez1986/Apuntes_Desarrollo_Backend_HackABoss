import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
         /********************************************************************************************************
         *                                   Respuestas - Tipos de Datos                                         *
         *********************************************************************************************************
         * 📌 Si quisieran contar el número de veces que un usuario inicia sesión, ¿qué tipo de dato usarían? int
         * 📌 ¿Qué tipo de dato usarían para indicar si un usuario está activo o inactivo en un sistema?  boolean
         * 📌 ¿Cuál sería el mejor tipo de dato para almacenar el número de habitantes de una ciudad? long
         * 📌 Si quisieran guardar el saldo de una cuenta bancaria, ¿qué tipo de dato elegirían? float
         * 📌 ¿Cómo representarían la temperatura de un lugar en Java? float
         * 📌 ¿En qué tipo de dato guardarían una edad? int
         * */

        /******************************************************
         *       Respuestas - Nombres de Variables            *
         ******************************************************
         * 📌 double alturaPersona; OK
         * 📌 double precio#; termina con caracter especial
         * 📌 boolean tieneDescuento; OK
         * 📌 boolean es Activo; tiene espacio
         * 📌 int numeroDeMascotas; OK
         * 📌 int 2edad; Comienza con número
         * */

        /*************** Operadores Aritméticos ***************/
        int suma = 5 + 8;
        int modulo = 10 % 3;

        /*************** Operadores Relacionales ***************/
        boolean esMayor = 5 > 8;
        boolean esIgual = 10 == 10;

        /*************** Operadores Lógicos ***************/
        boolean resultado = true && true && true && false;

        /*************** Operadores Asignación ***************/
        int numero = 5;
        numero += 10;

        /*********************************************************************************************
         *                                     Signed & Unsigned                                     *
         *********************************************************************************************
         * En Java, todos los tipos numéricos primitivos son signed (con signo), lo que significa que
         * pueden representar tanto números positivos como negativos. A diferencia de otros
         * lenguajes como C o C++, Java no tiene tipos unsigned (sin signo).
         *********************************************************************************************/


        /***********************************************
         *      Tabla de verdad - Álgebra de Boole     *
         ***********************************************
         * |   A   |   B   | A AND B | A OR B | NOT A
         * |-------|-------|---------|--------|-------
         * | false | false |  false  |  false | true
         * | false | true  |  false  |  true  | true
         * | true  | false |  false  |  true  | false
         * | true  | true  |  true   |  true  | false
         **********************************************/


        /*********************************************************************************************
         *                                     Ejercicio Práctico                                    *
         *********************************************************************************************
         * Dadas dos notas ingresadas por el usuario, escribir un programa en Java que calcule e
         * imprima el promedio de dichas notas.
         *********************************************************************************************/
        Scanner s = new Scanner(System.in);

        // Pedir las notas al usuario
        System.out.print("Ingresa la primera nota: ");
        float nota1 = s.nextInt();

        System.out.print("Ingrese la segunda nota: ");
        float nota2 = s.nextInt();

        // Calcular el promedio
        float promedio = (nota1 + nota2) / 2;

        // Imprimir el resultado
        System.out.println("El promedio es: " + promedio);

        // Cerrar el scanner
        s.close();
    }
}