package dia_10.ejercicio_1;

/* Crea una clase utilitaria llamada `FechaUtil` que contenga métodos estáticos para calcular la diferencia en días entre dos fechas de ida y vuelta.

### Requisitos:

- La clase `FechaUtil` debe contener un método estático `calcularDiferenciaDias` que reciba dos fechas (`LocalDate`) y retorne la diferencia en días.
- En el `main`, se deben probar las fechas de ida y vuelta llamando al método de `FechaUtil` e imprimiendo el resultado.
- Tip: usa la clase Period.between(fecha1, fecha2); dentro del método `calcularDiferenciaDias` para ayudarte con la solución.

**Ejemplo de uso:**

```java
LocalDate ida = LocalDate.of(2024, 3, 10);
LocalDate vuelta = LocalDate.of(2024, 3, 20);
long dias = FechaUtil.calcularDiferenciaDias(ida, vuelta);
System.out.println("Días de diferencia: " + dias);
```

**Salida esperada:**

```bash
Días de diferencia: 10
``` */

import java.time.LocalDate;

public class Ejercicio_1 {
	public static void main(String[] args) {
		LocalDate ida = LocalDate.of(2025, 4, 28);
		LocalDate vuelta = LocalDate.of(2025, 5, 2);
		long dias = FechaUtil.calcularDiferenciaDias(ida, vuelta);
		System.out.println("Días de diferencia: " + dias);
	}
}
