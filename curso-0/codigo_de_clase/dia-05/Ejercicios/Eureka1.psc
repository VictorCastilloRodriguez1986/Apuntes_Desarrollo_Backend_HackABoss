Algoritmo Eureka
	Definir password Como Cadena
	Definir tries Como Entero
	Definir acertado Como Logico
	tries = 3
	acertado = Falso
	
	Mientras tries > 0 Hacer
		Escribir "Introduce la clave"
		Leer password
		Si password == "eureka" Entonces
			tries = 0
			acertado = Verdadero
		SiNo
			tries = tries -1
			Escribir "Fallaste, te quedan ", tries, " intentos"
			
		Fin Si
	Fin Mientras
	
	Si acertado Entonces
		Escribir "Has acertado"
	SiNo
		Escribir "Has fallado, no tienes intentos"
	Fin Si
	
FinAlgoritmo
