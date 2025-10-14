package com.hackaboss;

import com.hackaboss.controllers.AutoController;
import com.hackaboss.entities.Auto;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AutoController autoController = new AutoController();
        int opcion = 0;
        while (true) {
            System.out.println("-----------------------");
            System.out.println("--- Menú del Garage ---");
            System.out.println("-----------------------");
            System.out.println("1. Cargar un nuevo auto");
            System.out.println("2. Listar autos");
            System.out.println("3. Consultar un auto");
            System.out.println("4. Actualizar un auto");
            System.out.println("5. Eliminar un auto");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Descripción del auto: ");
                    autoController.agregarAuto(scanner.nextLine());
                    System.out.println("Auto guardado exitosamente.");
                    break;
                case 2:
                    List<Auto> autos = autoController.listarAutos();
                    if (autos.isEmpty()) {
                        System.out.println("No hay autos estacionados.");
                    } else {
                        System.out.println("Autos estacionados: ");
                        for (Auto auto : autos) {
                            System.out.println(auto);
                        }
                    }
                    break;
                case 3:
                    System.out.print("ID del auto a consultar: ");
                    Auto auto = autoController.consultarAuto(scanner.nextLong());
                    System.out.println(auto != null ? auto : "Auto no encontrado.");
                    break;
                case 4:
                    System.out.print("ID del auto a actualizar: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine(); // limpiar buffer
                    System.out.print("Nueva descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.println(autoController.actualizarAuto(id, descripcion) ? "Auto actualizado." : "Auto no encontrado.");
                    break;
                case 5:
                    System.out.print("ID del auto a actualizar: ");
                    System.out.println(autoController.eliminarAuto(scanner.nextLong()) ? "Auto eliminado." : "Auto no encontrado.");
                    break;
                case 6:
                    System.out.println("¡Hasta la próxima!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}