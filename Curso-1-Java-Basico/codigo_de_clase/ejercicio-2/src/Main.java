import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Crear usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1: // Crear
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    usuarios.add(new Usuario(nombre, edad));
                    break;
                case 2: // Leer
                    System.out.println("Usuarios:");
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(i + ": " + usuarios.get(i));
                    }
                    break;
                case 3: // Actualizar
                    System.out.print("ID a modificar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (id >= 0 && id < usuarios.size()) {
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Nueva edad: ");
                        int nuevaEdad = scanner.nextInt();
                        usuarios.set(id, new Usuario(nuevoNombre, nuevaEdad));
                    } else {
                        System.out.println("ID inválido");
                    }
                    break;
                case 4: // Eliminar
                    System.out.print("ID a eliminar: ");
                    int eliminar = scanner.nextInt();
                    if (eliminar >= 0 && eliminar < usuarios.size()) {
                        usuarios.remove(eliminar);
                    } else {
                        System.out.println("ID inválido");
                    }
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}