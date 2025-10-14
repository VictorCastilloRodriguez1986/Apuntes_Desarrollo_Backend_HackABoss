Algoritmo NumMayor
	Definir num1, num2, num3, max Como Entero
	Escribir "Debes ingresar 3 numeros enteros distintos"
	Escribir "Dame el primer numero"
	Leer num1
	Escribir "Dame el segundo numero"
	Leer num2
	Escribir "Dame el tercer numero"
	Leer num3
	
	max = num1
	
	Si num2 > max Entonces
		max = num2
	Fin Si
	Si num3 > max Entonces
		max = num3
	Fin Si
	
	Escribir "El numero mayor es: ", max
FinAlgoritmo

//Algoritmo MayorDeTresNumeros
//	Definir numA, numB, numC Como Entero
//	Escribir 'Vamos a calcular cuál es el número mayor a partir de tres opciones'
//	Escribir 'Ingresa un primer número entero'
//	Leer numA
//	Escribir 'Ingresa un segundo número entero'
//	Leer numB
//	Escribir 'Ingresa un tercer número entero'
//	Leer numC
//	
//	Si numA > numB y numA > numC Entonces
//		Escribir 'El número mayor es ', numA
//	FinSi
//	Si numB > numC y numB > numA Entonces
//		Escribir 'El número mayor es ', numB
//	FinSi
//	Si numC > numA y numC > numB Entonces
//		Escribir 'El número mayor es ', numC
//	FinSi
//FinAlgoritmo

//Algoritmo MayorDeTresNumeros
//	Definir num_mayor, i, numero Como Entero
//	num_mayor <- 0
//	Escribir 'Introduce tres números enteros diferentes:'
//	Para i<-1 Hasta 3 Con Paso 1 Hacer
//		Escribir 'Introduce el numero ', i
//		Leer numero
//		Si numero > num_mayor Entonces
//			num_mayor <- numero
//		FinSi
//	FinPara
//	Escribir 'El número mayor es: ', num_mayor
//FinAlgoritmo

//Algoritmo MayorDeTres
//	Definir num1,num2,num3 Como Entero
//	Escribir "Introduzca el primer numero entero"
//	Leer num1
//	Escribir "Introduzca el segundo numero entero"
//	Leer num2
//	Escribir "Introduzca el tercer numero entero"
//	Leer num3
//	
//	Si num1 > num2 Entonces
//		Si num1 > num3 Entonces
//			Escribir "El numero mas alto es ", num1 
//		SiNo
//			Escribir "El numero mas alto es ", num3 
//		FinSi
//	SiNo
//		Si num2 > num3 Entonces
//			Escribir "El numero mas alto es ", num2 
//		SiNo
//			Escribir "El numero mas alto es ", num3 
//		FinSi
//	FinSi
//FinAlgoritmo