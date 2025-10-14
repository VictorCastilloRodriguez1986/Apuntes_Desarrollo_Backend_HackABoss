package dia01;

import dia01.exceptions.InventarioProductoException;

public class Ejercicio02 {
    private static String nombre = "Pantalón";
    private static Integer cantidad = 10;
    private static Double precioUnidad = 25.0;

    public static void main(String[] args) {
        System.out.println("Puedes añadir el producto al inventario");
        try {
            aniadirInventario(nombre, cantidad, precioUnidad);
        } catch (InventarioProductoException e) {
            System.err.println("Error gestionado - " + e.getMessage());
        } catch (Exception e){
            System.err.println("Error interno - " + e.getMessage());
        }
        System.out.println("Fin");
    }

    private static void aniadirInventario(String nombre,  Integer cantidad, Double precioUnidad) throws InventarioProductoException {
        if (nombre.isBlank() || nombre == null || cantidad == null || precioUnidad == null) {
            throw new InventarioProductoException("Todos los datos son obligatorios.");
        }
        if (cantidad <= 0 ){
            throw new InventarioProductoException("Cantidad no valida.");
        }
        if (precioUnidad <= 0.0 ){
            throw new InventarioProductoException("Precio de la unidad no valido.");
        }
        System.out.println("Producto añadido!");

    }
}
