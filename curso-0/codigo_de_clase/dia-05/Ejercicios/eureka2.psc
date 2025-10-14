Algoritmo eureka
	Definir password Como Cadena
	Definir tries Como Entero
	Definir acertado Como Lógico
	acertado <- Falso
	Escribir 'Tienes 3 intentos para ingresar la clave'
	Para tries<-1 Hasta 3 Con Paso 1 Hacer
		Escribir "Intento ", tries, "Introduce la contraseña"
		Leer password
		Si password == "eureka" Entonces
			acertado = Verdadero
			tries = 4
		SiNo
			Si tries <> 3 Entonces
				Escribir "Clave incorrecta, te quedan ", 3 - tries, " intentos"
			Fin Si
		Fin Si
	FinPara
	
	Si acertado Entonces
		Escribir "Has acertado"
	SiNo
		Escribir "Has fallado, no tienes intentos"
	Fin Si
FinAlgoritmo
