package dia_9.ejercicio_2;

/* Un administrador de una **tienda de electrónica** necesita un programa para gestionar los **productos** en su inventario. Para ello, necesita la creación de una clase Producto que cuente con los siguientes datos: código, nombre, marca, tipo, precio costo, precio venta, cantidad en stock.

A partir de esto, realizar las siguientes acciones en el programa desarrollado:

a) Crear 10 objetos de tipo Producto con sus correspondientes valores cargados (por ejemplo, teléfono, laptop, auriculares/cascos, cargador, tablet, etc).

b) Guardar estos objetos creados en un ArrayList.

c) Recorrer el ArrayList y determinar el producto con el mayor precio de venta.

d) Recorrer el ArrayList y determinar el producto con el menor precio de costo.

e) Borrar el producto que se encuentre en la posición 5 del ArrayList.

f) Determinar el producto que tenga la mayor cantidad en stock. A ese producto, descontarle 3 unidades del stock y actualizar el registro en la lista en base a eso.

g) Mostrar siempre por consola un mensaje informativo luego de resolver cada punto. */

import java.util.ArrayList;

public class Ejercicio_2 {
		public static void main(String[] args) {
			// Crear un ArrayList para almacenar productos
			ArrayList<Producto> inventario = new ArrayList<>();

			// Crear 10 objetos de tipo Producto con sus correspondientes valores
			// Guardar estos objetos creados en un ArrayList.
			inventario.add(new Producto(1, "Teléfono", "Samsung", "Smartphone", 300.0, 450.0, 20));
			inventario.add(new Producto(2, "Laptop", "HP", "Portátil", 600.0, 900.0, 10));
			inventario.add(new Producto(3, "Auriculares/Cascos", "Sony", "Accesorio", 40.0, 70.0, 50));
			inventario.add(new Producto(4, "Cargador", "Apple", "Accesorio", 15.0, 25.0, 30));
			inventario.add(new Producto(5, "Tablet", "Lenovo", "Tablet", 200.0, 300.0, 15));
			inventario.add(new Producto(6, "Smartwatch", "Fitbit", "Wearable", 80.0, 130.0, 12));
			inventario.add(new Producto(7, "Altavoz Bluetooth", "JBL", "Accesorio", 50.0, 80.0, 25));
			inventario.add(new Producto(8, "Monitor", "Dell", "Accesorio", 100.0, 150.0, 8));
			inventario.add(new Producto(9, "Impresora", "Epson", "Accesorio", 70.0, 100.0, 18));
			inventario.add(new Producto(10, "Router Wi-Fi", "Linksys", "Accesorio", 25.0, 40.0, 22));

			// Recorrer el ArrayList y determinar el producto con el mayor precio de venta.
			double maxPrecioVenta = Double.MIN_VALUE;
			Producto productoMaxPrecioVenta = null;
			for (Producto p: inventario){
				if(p.getPrecioVenta() > maxPrecioVenta){
					maxPrecioVenta = p.getPrecioVenta();
					productoMaxPrecioVenta = p;
				}
			}
			System.out.println("El producto " + productoMaxPrecioVenta.getNombre() + " es el producto más caro con un precio de " + maxPrecioVenta + " euros" );

			// Recorrer el ArrayList y determinar el producto con el menor precio de costo.
			double minPrecioCosto = Double.MAX_VALUE;
			Producto productoMinPrecioCosto = null;
			for (Producto p: inventario){
				if(p.getPrecioCosto() < minPrecioCosto){
					minPrecioCosto = p.getPrecioCosto();
					productoMinPrecioCosto = p;
				}
			}
			System.out.println("El producto " + productoMinPrecioCosto.getNombre() + " es el producto más barato con un precio costo de " + minPrecioCosto + " euros" );

			// Borrar el producto que se encuentre en la posición 5 del ArrayList.
			if(inventario.size() > 5){
				Producto productoEliminado = inventario.remove(5);
				System.out.println("Se eliminó el producto en la posición 5: " + productoEliminado.getNombre());
			}else{
				System.out.println("No existe ningún producto en la posición 5");
			}

			// Determinar el producto que tenga la mayor cantidad en stock. A ese producto, descontarle 3 unidades del stock y actualizar el registro en la lista en base a eso.
			int maxStock = Integer.MIN_VALUE;
			Producto productoMaxStock = null;
			for (Producto p: inventario){
				if(p.getCantidadEnStock() > maxStock){
					maxStock = p.getCantidadEnStock();
					productoMaxStock = p;
				}
			}
			if (productoMaxStock != null){
				productoMaxStock.setCantidadEnStock(maxStock - 3);
				System.out.println("El producto con más stock es " + productoMaxStock.getNombre());
				System.out.println("Nueva cantidad en stock: " + productoMaxStock.getCantidadEnStock());
			}else{
				System.out.println("No hay productos en el inventario");
			}
		}
}
