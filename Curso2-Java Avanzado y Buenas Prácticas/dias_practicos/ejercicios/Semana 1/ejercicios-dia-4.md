## Programación Funcional y Expresiones Lambda

### Ejercicio Nº 1 - Consigna de registrar sueldos de empleados:

Imagina que estás desarrollando un sistema de gestión de empleados para una empresa. Los usuarios pueden realizar operaciones como registrar empleados, verificar si el salario de un empleado cumple con un umbral mínimo y listar todos los empleados registrados. Para optimizar el código, la empresa ha decidido usar programación funcional y expresiones lambda.

Tu tarea es implementar una aplicación que utilice los siguientes conceptos en un solo ejercicio:

1. **Programación funcional:** Utiliza funciones y expresiones lambda para simplificar el manejo de listas de empleados.
2. **Expresiones lambda:** Implementa funciones anónimas que procesen los datos de los empleados.
3. **IllegalArgumentException:** Debes lanzarla cuando el usuario ingrese un nombre de empleado vacío o un salario negativo.
4. **Función lambda con forEach:** Utiliza una expresión lambda para recorrer y mostrar la lista de empleados.

### Requisitos de la implementación

- Crea una clase llamada `Empleado` con atributos como `nombre` y `salario`.
- Crea una clase llamada `GestionEmpleados` que gestione una lista de empleados.
- Implementa métodos para:
  - Añadir empleados a la lista.
  - Verificar si el salario de un empleado cumple con un umbral mínimo.
  - Listar todos los empleados utilizando una expresión lambda con `forEach`.
- Cada método debe manejar adecuadamente las excepciones indicadas.

### Ejemplo de ejecución

```
Ingrese el nombre del empleado: Juan
Ingrese el salario: 3000
Empleado registrado: Juan - $3000

Ingrese el salario mínimo para verificar: 2500
El salario de Juan cumple con el umbral.

Ingrese el salario mínimo para verificar: -100
Error: El salario no puede ser negativo.
```

¡Asegúrate de utilizar programación funcional siempre que sea posible para hacer el código más conciso y claro!
