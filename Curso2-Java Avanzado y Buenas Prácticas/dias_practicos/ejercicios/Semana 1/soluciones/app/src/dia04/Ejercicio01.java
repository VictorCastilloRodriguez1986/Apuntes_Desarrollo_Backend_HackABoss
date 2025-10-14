package dia04;

import dia04.entities.Empleado;
import dia04.entities.GestionEmpleados;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        String nombre;
        Double salario;
        Double salarioMinimo;
        Scanner input = new Scanner(System.in);
        Integer opcion = 0;

        GestionEmpleados gestionEmpleados = new GestionEmpleados();

        do {
            imprimirMenu();

            try {
                opcion = input.nextInt();
                // Elimino el salto de linea pendiente
                input.nextLine();
            } catch (Exception e) {
                System.err.println("Operación no valida, no insertaste un número");
                input.next();
                continue;
            }

            switch (opcion) {
                case 0:
                    System.out.println("Adiós");
                    break;
                case 1:
                    try {
                        System.out.println("Ingrese el nombre del empleado:");
                        nombre = input.nextLine();
                        String algo = null;
                        //algo.repeat(4);
                        try{
                            System.out.println("Ingrese el salario:");
                            salario = input.nextDouble();
                        }catch (Exception e){
                            throw new IllegalArgumentException("Valor del salario no valido.");
                        }
                        Empleado empleado = new Empleado(nombre, salario);
                        gestionEmpleados.addEmpleado(empleado);

                    } catch (IllegalArgumentException e) {
                        System.err.println("Error gestionado: " + e.getMessage());
                    } catch (Exception e) {
                        System.err.println("Error interno: " + e.getMessage());
                    } finally {
                        // Elimino el salto de linea pendiente
                        input.nextLine();
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Ingrese el salario mínimo de su empresa:");
                        salarioMinimo = input.nextDouble();
                        gestionEmpleados.checkSalarioEmpleado(salarioMinimo);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error gestionado: " + e.getMessage());
                    } catch (Exception e) {
                        System.err.println("Error interno: " + e.getMessage());
                    }finally {
                        // Elimino el salto de linea pendiente
                        input.nextLine();
                    }
                    break;
                case 3:
                    gestionEmpleados.listEmpleados();
                    break;
                default:
                    System.out.println("Operación no valida");
            }
        } while (opcion != 0);

        input.close();

    }

    public static void imprimirMenu() {
        System.out.println();
        System.out.println("Ingrese una opción:");
        System.out.println("1 - Añadir empleado");
        System.out.println("2 - Check salario empleados");
        System.out.println("3 - Listar empleados");
        System.out.println("0 - Salir");
    }


}
