Algoritmo CalcularDescuentos
	Definir precio, descuento, precioFinal Como Real
	
	Escribir 'Ingrese el precio original del producto'
	Leer precio
	
	Escribir 'Ingrese el descuento del producto'
	Leer descuento
	
	precioFinal = precio - (precio*descuento/100)
	
	Escribir 'El precio final despues del descuento es: ', precioFinal, '?'
FinAlgoritmo