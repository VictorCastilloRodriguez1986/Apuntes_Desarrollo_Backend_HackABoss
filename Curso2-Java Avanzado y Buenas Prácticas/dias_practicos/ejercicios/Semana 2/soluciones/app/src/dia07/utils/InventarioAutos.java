package dia07.utils;

import dia07.Auto;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventarioAutos {

    public static <T> void agregar(List<T> inventario, T item){
        inventario.add(item);
    }

    public static <T> List<T> buscarPor(List<T> inventario, Predicate<T> criterio){
        return inventario.stream().filter(criterio).toList();
    }

    public static <T> Double calcularValorTotal(List<T> inventario, Function<T, Double> extractor){
        return inventario.stream().mapToDouble(extractor::apply).sum();
    }


}
