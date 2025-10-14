package dia_4;

/*
Ejercicio 3 - Arreglos: Vectores

Una web de meteorología necesita un programa que, al ingresar las 7 temperaturas máximas de la última semana, calcule la temperatura **promedio máxima** registrada.

- Para ello, deberás manejar un **vector** donde en cada posición se almacene la temperatura máxima correspondiente a cada día.
- Una vez almacenadas las temperaturas, deberás calcular el promedio recorriendo el vector y mostrando el resultado por pantalla.
 */

public class Ejercicio_3 {
	public static void main(String[] args) {
		// Definimos un vector para almacenar las temperaturas máximas de la semana
		double[] temperaturasMaximas = new double[7];
		// Se podría haber declarado temperaturasMaximas con valores iniciales
		// double[] temperaturasMaximas = {25.5, 28.0, 30.2, 27.8, 26.5, 29.1, 31.0};
		double sumaTemperaturas = 0.0;

		// Simulamos el ingreso de las temperaturas máximas
		// En un caso real, podríamos usar Scanner para leer del usuario
		// También se podría hacer en el bucle para pedir cada temperatura
		temperaturasMaximas[0] = 25.5;
		temperaturasMaximas[1] = 28.0;
		temperaturasMaximas[2] = 30.2;
		temperaturasMaximas[3] = 27.8;
		temperaturasMaximas[4] = 26.5;
		temperaturasMaximas[5] = 29.1;
		temperaturasMaximas[6] = 31.0;

		// Calculamos la suma de las temperaturas
		for (double temperatura : temperaturasMaximas) {
			// Se podría haber asignado aquí el valor a temperatura en vez hacerlo antes
			// temperatura = 25.5;
			sumaTemperaturas += temperatura;
		}

		// Calculamos el promedio
		double promedioTemperatura = sumaTemperaturas / temperaturasMaximas.length;

		// Mostramos el resultado
		// Usamos printf para formatear el número a dos decimales y situar el valor de promedioTemperatura en la posición indicada
		System.out.printf("La temperatura promedio máxima de la semana es: %.2f ºC", promedioTemperatura);
	}
}
