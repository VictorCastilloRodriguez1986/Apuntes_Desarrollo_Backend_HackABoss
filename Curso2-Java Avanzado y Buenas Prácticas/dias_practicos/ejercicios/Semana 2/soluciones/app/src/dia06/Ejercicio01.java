package dia06;

import dia05.Categoria;
import dia05.Empleado;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Ejercicio01 {
    public static void main(String[] args) {
        //  "Reunión", "Conferencia", "Taller"
        List<Evento> eventos = new ArrayList<>();

        eventos.add(new Evento("Reunion 1", LocalDate.of(2025, 5, 14), "Reunion"));
        eventos.add(new Evento("Reunion 2", LocalDate.of(2025, 5, 15), "Reunion"));
        eventos.add(new Evento("Conferencia 1", LocalDate.of(2025, 5, 15), "Conferencia"));
/*        eventos.add(new Evento("Conferencia 2", LocalDate.of(2025, 5, 16), "Conferencia"));
        eventos.add(new Evento("Taller 1", LocalDate.of(2025, 5, 17), "Taller"));
        eventos.add(new Evento("Taller 2", LocalDate.of(2025, 5, 18), "Taller"));
        eventos.add(new Evento("Taller 3", LocalDate.of(2025, 5, 18), "Taller"));*/

        //Filtra los eventos que están programados para una fecha específica.
        List<Evento> eventosDeHoy = eventos.stream().filter(e -> e.getFecha().isEqual(LocalDate.now())).toList();
        if (eventosDeHoy.isEmpty()) {
            System.out.println("Lo sentimos, no hay eventos para el día de hoy");
        } else {
            System.out.println("Eventos de hoy:");
            eventosDeHoy.forEach(System.out::println);
        }
        //Agrupa los eventos por categoría y cuenta cuántos eventos hay en cada categoría.
        Map<String, Long> numeroEventosPorCategoria = eventos.stream()
                .collect(Collectors.groupingBy(Evento::getCategoria, Collectors.counting()));
        System.out.println("Número eventos por categoria. Datos: " + numeroEventosPorCategoria.toString());

        //Encuentra el evento más próximo en el tiempo utilizando Optionals.
        Optional<Evento> proximoEvento = eventos.stream()
                .filter(e -> e.getFecha().isAfter(LocalDate.now()))
                .sorted(Comparator.comparing(Evento::getFecha))
                .findFirst();
        if (proximoEvento.isPresent()) {
            System.out.println("El proximo evento es: " + proximoEvento.get());
        }else {
            System.out.println("No hay eventos futuros.");
        }

        // Todos los eventos a partir de hoy. Condición:  !e.getFecha().isBefore(LocalDate.now())
    }
}
