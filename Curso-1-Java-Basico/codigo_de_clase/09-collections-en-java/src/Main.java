import java.util.*;

public class Main {
    public static void main(String[] args) {
        /************************* ArrayList *************************/
        Scanner s = new Scanner(System.in);
        List<Integer> notas = new ArrayList<>();
        String respuesta = "n";

        System.out.println("-------------------------------------------");
        System.out.println("Bienvenida a la app de cálculo de promedios");
        System.out.println("-------------------------------------------");

        do {
            System.out.print("Ingrese la primera nota: ");
            notas.add(s.nextInt());
            System.out.println("¿Quieres ingresar otra nota?");
            s.nextLine();
            respuesta = s.nextLine();
        } while (respuesta.equals("s"));

        int acu = 0;
        for (int nota : notas) {
            acu += nota;
        }
        System.out.println("El promedio es: " + acu / notas.size());

        /************************* LinkedList *************************/
        // Crear lista
        List<String> nombres = new LinkedList<>();

        // Agregar elementos
        nombres.add("Carlos");
        nombres.add("Daniel");
        nombres.add("Esteban");

        // Agregar al inicio y al final
        nombres.addFirst("Ana");
        nombres.addLast("Zack");

        // Mostrar todos los elementos
        System.out.println("Listas de nombres");
        for (String nombre : nombres){
            System.out.println(nombre);
        }

        // Eliminar uno
        nombres.remove("Daniel");

        // Mostrar luego de eliminar
        System.out.println("Luego de eliminar a Daniel");
        for (String nombre : nombres){
            System.out.println(nombre);
        }

        /************************* HashMap *************************/
        Map<String, Integer> prom = new HashMap<>();
        prom.put("Ana", 8);
        prom.put("Luis", 7);
        prom.put("Carlos", 9);

        for (String alumno : prom.keySet()){
            System.out.println(alumno + ": " + prom.get(alumno));
        }
    }
}