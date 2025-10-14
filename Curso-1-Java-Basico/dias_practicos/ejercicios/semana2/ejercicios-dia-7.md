## Ejercicio Nº 1 - Herencia, Polimorfismo y Encapsulamiento

Crea una clase `Animal` con los atributos: `id`, `nombre`, `edad`, `tipoPiel` y `tipoAlimentacion` (con sus métodos y constructores correspondientes). 

Agrega también un método llamado `saludar` que emita el siguiente mensaje por pantalla:
**“Hola, soy un animal”**

Luego, realiza lo siguientes pasos:

a) Crea sus clases hijas que hereden los atributos y métodos:
    
- `Mamífero` con atributos adicionales: `numeroPatas`, `tipoReproduccion`, `colorPelaje`, `habitat`.
	
- `Ave` con atributos adicionales: `envergaduraAlas`, `tipoVuelo`, `colorPlumaje`, `tipoPico`.
	
- `Reptil` con atributos adicionales: `longitud`, `tipoEscamas`, `tipoVeneno`, `habitat`.
        

b) Una vez creadas las clases hijas, sobrescribe el método `saludar` en cada una:  
    
- **"Mamífero":** debe mostrar `"Hola, soy un mamífero"`.
	
- **"Ave":** debe mostrar `"Hola, soy un ave"`.
	
- **"Reptil":** debe mostrar `"Hola, soy un reptil"`.
	

c) En el método `main`, crea un objeto de cada clase hija.

Llama al método `saludar` desde cada objeto y verifica que se ejecuta el mensaje correspondiente.
	

d) Crea un objeto de tipo `Animal` e intenta asignarle el `Mamifero` creado.
- ¿Qué sucede?  
- ¿Es posible hacerlo?  
- ¿Qué propiedad del polimorfismo se aplica en este caso?
	

e) Cambia el modificador de acceso de los métodos de `public` a `private`. 
Luego, intenta acceder a esos métodos desde el `main`.
- ¿Qué sucede?  
- ¿Es posible hacerlo?

<br>

## Ejercicio Nº 2 - Herencia y Polimorfismo

Crea una clase llamada `Vestimenta` con los siguientes atributos: `codigo`, `nombre`, `precio`, `marca`, `talla` y `color`.  

Incluye sus constructores, métodos _getters_ y _setters_ correspondientes.

a) Crea las siguientes clases hijas que hereden sus atributos y métodos:
    
- `Zapato`: atributos adicionales `material`, `tipoCierre`
	
- `Pantalon`: atributos adicionales `estilo`, `tipoTejido`
	
- `Camiseta`: atributos adicionales `manga`, `cuello`
	
- `Sombrero`: atributos adicionales `tipo`, `tamano`
        
b) En el `main`, crear un vector de tipo `Vestimenta` y almacena los siguientes objetos (con parámetros): 
	
- 3 objetos de tipo `Zapato`
    
- 3 objetos de tipo `Pantalon`
    
- 2 objetos de tipo `Camiseta`
    
- 1 objeto de tipo `Sombrero`
	    
c) En cada subclase, crea un método con el mismo nombre que muestre un mensaje personalizado: 
    
- `Zapato`: "Estos zapatos son de marca: " + marca
	
- `Pantalon`: "Estos pantalones son de estilo: " + estilo
	
- `Camiseta`: "Esta camiseta es de manga: " + manga
	
- `Sombrero`: "Este sombrero es del tipo: " + tipo
        
d) Recorre el vector creado en el apartado b) y ejecuta el método correspondiente para cada objeto almacenado.
    

**PISTA:**
_Todos los objetos tendrán un método con el **mismo nombre**, pero cada uno mostrará un **mensaje distinto**. Esto permite aplicar **herencia y sobreescritura** de métodos (polimorfismo).



