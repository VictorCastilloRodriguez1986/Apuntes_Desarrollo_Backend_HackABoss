import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /******************************************************
         *               Estructuras Condicionales            *
         *****************************************************/

        /*************** If ***************/
        int temperatura = 20;
        if(temperatura > 24){
            System.out.println("Encender aire acondicionado");
        }

        /*************** If-Else ***************/
        int edad = 14;
        if (edad > 18){
            System.out.println("Puede entrar");
        } else {
            System.out.println("No puede entrar");
        }

        /*************** If's Anidados ***************/
        int nota = 9;
        if(nota > 7){
            System.out.println("Promocionado");
        } else if(nota > 4){
            System.out.println("Aprobado");
        } else {
            System.out.println("Desaprobado");
        }

        /*************** Switch ***************/
        int dia = 1;
        switch (dia){
            case 1:
                System.out.println("Hoy es Lunes");
                break;
            case 2:
                System.out.println("Hoy es Martes");
                break;
            default:
                System.out.println("Día no válido!");
        }

        /******************************************************
         *               Estructuras Repetititvas             *
         *****************************************************/

        /*************** Centinela ***************/
        Scanner s = new Scanner(System.in);
        int num;
        do {
            System.out.println("Ingrese el numero 0 para salir");
            num = s.nextInt();
        } while (num != 0);
        System.out.println("Fin del Programa");

        /*************** Bucle FOR ***************/
        for (int i=0;i<=5;i++){
            System.out.println("Estamos en la iteración Nro: " + i);
        }

        /******************************************************
         *                        Arreglos                    *
         *****************************************************/

        /*************** Vectores ***************/
        int[] vector = new int[3];              // Crea array de 5 elementos

        vector[0] = 5;                          // Carga elementos del vector
        vector[1] = 10;
        vector[2] = 7;

        System.out.println(vector[1]);          // Lee elemento específico

        // Ejemplo: Hallar el número más alto en un vector
        int mayor = 0;
        for (int i = 0; i < vector.length; i++){
            if(vector[i] > mayor){
                mayor = vector[i];
            }
        }
        System.out.println("El mayor es: " + mayor);

        /*************** Matrices ***************/
        // Ejemplo: Calcular el promedio de notas de varios alumnos
        int[][] notas = {
                {4, 7, 9},      // Alumno 1
                {5, 8, 2},      // Alumno 2
                {9, 2, 2},      // Alumno 3
        };
        int prom;
        for (int i = 0; i < notas.length; i++) {
            prom = 0;
            for (int j = 0; j < notas[i].length; j++) {
                prom += notas[i][j];
            }
            System.out.println("El promedio del Alumno " + (i+1) + " es: " + prom/notas.length);
        }
    }
}