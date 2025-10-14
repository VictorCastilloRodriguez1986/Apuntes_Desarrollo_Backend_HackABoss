package dia05;

import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio01 {
    public static void main(String[] args) {
        Double sueldoLimite = 2500.0;
        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado("Ana", Categoria.Gerente, 3800.00));
        empleados.add(new Empleado("Sara", Categoria.Analista, 2800.00));
        empleados.add(new Empleado("Luis", Categoria.Desarrollador, 1800.00));
        empleados.add(new Empleado("Carla", Categoria.Gerente, 4000.00));
        empleados.add(new Empleado("Pablo", Categoria.Analista,  3000.00 ));
        empleados.add(new Empleado("Maria", Categoria.Desarrollador, 2000.00 ));

        // Filtra los empleados cuyo salario sea mayor a cierto valor específico
        List<Empleado> empleadosFiltrados = empleados.stream().filter(e->e.getSalario()>=sueldoLimite).toList();
        if(empleadosFiltrados.isEmpty()){
            System.out.println("Ningún empleado con sueldo >= " + sueldoLimite);
        }else{
            System.out.println("Listado empleados con suelgo >= " + sueldoLimite + " :");
            empleadosFiltrados.forEach(System.out::println);
        }

        // Agrupa los empleados por categoría y calcula el salario promedio para cada categoría
        //Map<Categoria, List<Empleado>> empleadosPorCategoria = empleados.stream().collect(Collectors.groupingBy(Empleado::getCategoria));
        //System.out.println(empleadosPorCategoria.toString());

        Map<Categoria, Double> empleadosPorCategoriaMediaSueldo = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getCategoria, Collectors.averagingDouble(Empleado::getSalario) ));
        System.out.println("Media sueldo por categoria. Datos: " + empleadosPorCategoriaMediaSueldo.toString() );

        // Encuentra al empleado con el salario más alto.
        System.out.println("El empleado con el sueldo mas alto es: " + empleados.stream().max(Comparator.comparingDouble(Empleado::getSalario)).orElse(null));

    }
}
