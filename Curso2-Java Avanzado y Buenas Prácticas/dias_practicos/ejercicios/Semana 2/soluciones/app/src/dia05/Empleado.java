package dia05;

public class Empleado {
    private String nombre;
    private Double salario;
    private Categoria categoria;

    public Empleado() {
    }

    public Empleado(String nombre, Categoria categoria, Double salario) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    // hola
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", categoria=" + categoria;
    }
}
