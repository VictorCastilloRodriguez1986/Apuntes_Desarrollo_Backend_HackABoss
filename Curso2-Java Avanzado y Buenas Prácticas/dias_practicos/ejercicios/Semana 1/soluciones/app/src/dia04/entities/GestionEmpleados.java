package dia04.entities;

import java.util.ArrayList;
import java.util.List;

public class GestionEmpleados {
    private List<Empleado> empleados;

    public GestionEmpleados() {
        this.empleados = new ArrayList<Empleado>();
    }

    //Añadir empleados a la lista.
    public void addEmpleado(Empleado empleado) {
        if(empleado.getNombre().isEmpty()){
                throw new IllegalArgumentException("Nombre empleado obligatorio.");
        }

        if(empleado.getSalario() <= 0){
            throw new IllegalArgumentException("El salario no puede ser 0 o negativo.");
        }

        empleados.add(empleado);
        System.out.println("Empleado registrado: " + empleado.getNombre() + " - " + empleado.getSalario());
    }

    //Verificar si el salario de un empleado cumple con un umbral mínimo.
    public void checkSalarioEmpleado(Double salarioMinimo) {
        if(salarioMinimo<=0){
            throw new IllegalArgumentException("El salario mínimo no puede ser 0 o negativo.");
        }
        List<Empleado> empleadosNoSalarioMinimo = empleados.stream().filter(empleado -> empleado.getSalario() < salarioMinimo).toList();

        if (empleadosNoSalarioMinimo.size() == 0) {
            System.out.println("Ningún empleado con salario inferior al mínimo.");
        } else {
            System.out.println("Empleados con salario inferior al mínimo:");
            empleadosNoSalarioMinimo.forEach(System.out::println);
        }
    }

    //Listar todos los empleados utilizando una expresión lambda con forEach.
    public void listEmpleados() {
        if (empleados.size() == 0) {
            System.out.println("Ningún empleado registrado.");
        } else {
            System.out.println("Empleados:");
            empleados.forEach(System.out::println);
        }

    }

}
