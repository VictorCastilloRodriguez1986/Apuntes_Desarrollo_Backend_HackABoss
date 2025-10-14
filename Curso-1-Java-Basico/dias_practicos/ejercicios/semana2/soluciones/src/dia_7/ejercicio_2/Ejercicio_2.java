package dia_7.ejercicio_2;

public class Ejercicio_2 {
	public static void main(String[] args) {
		// Crear un vector de tipo Vestimenta y almacenar prendas de diferentes tipos
		Vestimenta[] prendas = new Vestimenta[9];

		// Crear objetos de cada tipo de prenda y almacenarlos en el vector
		prendas[0] = new Zapato("Cuero", "Cordones", "001", "Zapatos Deportivos", 59.99, "Nike", "42", "Negro");
		prendas[1] = new Zapato("Piel", "Hebilla", "002", "Zapatos Formales", 79.99, "Clarks", "40", "Marrón");
		prendas[2] = new Zapato("Lona", "Cordones", "003", "Zapatos Casuales", 49.99, "Adidas", "41", "Blanco");

		prendas[3] = new Pantalon("Jeans Skinny", "Denim", "101", "Jeans Skinny", 39.99, "Levi's", "32x32", "Azul");
		prendas[4] = new Pantalon("Pantalón Chino", "Algodón", "102", "Pantalón Chino", 29.99, "Wrangler", "34x32", "Beige");
		prendas[5] = new Pantalon("Pantalón Deportivo", "Poliéster", "103", "Pantalón Deportivo", 19.99, "Nike", "M", "Negro");

		prendas[6] = new Camiseta("Corta", "Cuello Redondo", "201", "Camiseta Manga Corta", 14.99, "H&M", "L", "Blanco");
		prendas[7] = new Camiseta("Larga", "Cuello V", "202", "Camiseta Manga Larga", 16.99, "Gap", "S", "Gris");

		prendas[8] = new Sombrero("Deportivo", "Única", "301", "Gorra deportiva", 24.99, "Topper", "Única", "Anaranjado");

		// Recorrer el vector y ejecutar el método que corresponde en cada posición
		for (Vestimenta prenda : prendas) {
			prenda.mostrarMensaje(); // Método común a todas las prendas
			System.out.println(); // Separador entre prendas
		}
	}
}
