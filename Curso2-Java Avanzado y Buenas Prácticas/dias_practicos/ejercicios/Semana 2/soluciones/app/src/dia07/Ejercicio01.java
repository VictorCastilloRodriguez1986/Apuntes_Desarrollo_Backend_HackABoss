package dia07;

import java.util.ArrayList;
import java.util.List;

import static dia07.utils.InventarioAutos.*;

public class Ejercicio01 {
    public static void main(String[] args) {
        List<Auto> inventario = new ArrayList<>();

        // Agregar autos
        agregar(inventario, new Auto("Toyota", "Corolla", 2020, 18000.00));
        agregar(inventario, new Auto("Ford", "Fiesta", 2018, 12000.00));
        agregar(inventario, new Auto("Toyota", "Camry", 2022, 24000.00));
        agregar(inventario, new Auto("Honda", "Civic", 2020, 20000.00));

        //inventario.forEach(System.out::println);

        //Buscar Autos por Marca o Año: Implementa métodos genéricos que permitan buscar autos por marca o año dentro del inventario.
        List<Auto> toyotas = buscarPor(inventario, a -> a.getMarca().equalsIgnoreCase("Toyota"));
        System.out.println("Toyotas:" + toyotas.toString());

        List<Auto> anio2020 = buscarPor(inventario, a -> a.getAnio() == 2020);
        System.out.println("Autos del año 2020:" + anio2020.toString());

        //Calcular el Valor Total del Inventario: Desarrolla un método genérico que calcule el valor total de todos los autos en el inventario.
        System.out.println("El precio de todas las autos es de: " + calcularValorTotal(inventario, Auto::getPrecio) );
    }
}
