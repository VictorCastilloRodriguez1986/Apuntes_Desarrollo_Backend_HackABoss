package dia_9.ejercicio_1;

/* Un **sistema de gestión de vehículos** necesita ser desarrollado para una futura implementación para una tienda de venta de autos. Se requiere utilizar para su implementación tanto clases abstractas como interfaces para modelar este sistema.

a) **Clase Abstracta Vehiculo:** Crear una clase abstracta llamada Vehiculo con los siguientes atributos: id, placa, marca, modelo, año, costo. Establecer un método abstracto para calcular la antigüedad del vehículo.

b) **Interfaces:** Crea dos interfaces llamadas Electrico y Combustion con métodos abstractos cargarEnergia() y recargarCombustible() respectivamente. En ambos casos, cuando se implementen en sus respectivas clases, deben mostrar un mensaje de qué tipo de recarga están haciendo.

c) **Clase Auto:** Crea una clase Auto que herede de Vehiculo e implemente la interfaz Electrico. Agrega atributos específicos para los autos eléctricos, como capacidadBateria (en mah) y autonomia (en hs). Implementa los métodos abstractos de la clase abstracta Vehiculo y los de la interfaz Electrico.

d) **Clase Camioneta:** Crea una clase Camioneta que herede de Vehiculo e implemente la interfaz Combustion. Agrega atributos específicos para las camionetas de combustión, como capacidadTanque y consumoCombustible. Implementa los métodos abstractos de la clase abstracta y los de la interfaz.

e) **Clase Moto:** Crea una clase Moto que herede de Vehiculo e implemente la interfaz Combustion. Agrega atributos específicos para las motos de combustión, como cilindrada y tipoMotor. Implementa los métodos abstractos de la clase abstracta y los de la interfaz.

f) **Main:** En el programa principal, crea objetos de diferentes tipos de vehículos (autos eléctricos, camionetas de combustión, motos de combustión) y añádelos a un ArrayList de tipo Vehiculo. Muestra información sobre cada uno de ellos, incluyendo el calculo de la antigüedad y la recarga de energía o combustible según corresponda.

g) **Polimorfismo:** Recorrer el ArrayList de Vehículos y mostrar la información de cada uno de ellos.


**Nota:** _Recuerda que la antigüedad de un vehículo se calcula restando del año actual el año de fabricación del auto. Por ejemplo: 2023 - 2018= 5 años de antigüedad_ */

import dia_9.ejercicio_1.clases.Vehiculo;
import dia_9.ejercicio_1.clases.Auto;
import dia_9.ejercicio_1.clases.Camioneta;
import dia_9.ejercicio_1.clases.Moto;
import dia_9.ejercicio_1.interfaces.Combustion;
import dia_9.ejercicio_1.interfaces.Electrico;

import java.util.ArrayList;

public class Ejercicio_1 {
	public static void main(String[] args) {
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();

		vehiculos.add(new Auto(1, "123", "Ford", "Fiesta", 2015, 12000.00, 2000, 500));
		vehiculos.add(new Moto(2, "122", "Ducati", "Multistrada", 2020, 20000.00, 1200, "V4"));
		vehiculos.add(new Camioneta(3, "222", "Fiat", "Ducato", 2018, 25000.00, 80, 5.00));

		for (Vehiculo v : vehiculos) {
			System.out.println(v);
			System.out.println("Antigüedad: " + v.calcularAntiguedad());
			if (v instanceof Electrico) {
				((Electrico) v).cargarEnergia();
			} else {
				((Combustion) v).recargarCombustible();
			}
			System.out.println();
		}
	}
}
