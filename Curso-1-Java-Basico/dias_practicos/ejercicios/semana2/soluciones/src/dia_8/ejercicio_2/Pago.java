package dia_8.ejercicio_2;

public class Pago {
	// Atributos
	private TipoPago tipoPago;

	// Constructores
	public Pago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	// Métodos
	public void mostrarTipoPago(){
		System.out.println("El tipo de pago es: " + this.tipoPago);
	}
}
