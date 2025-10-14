public class Videojuego {
    public static void main(String[] args) {
        /***************************************************************************************************************
         *                                            Instrucciones                                                    *
         ***************************************************************************************************************
         1. Definir una clase base Personaje para un videojuego RPG. Debe incluir atributos como nombre, nivel, puntos
         de vida y los métodos mostrarInfo() y atacar()
         2. Crea un constructor que reciba el nombre del personaje, y establezca los valores por defecto de nivel en 1
         y puntos de vida en 100.
         3. Luego, crear clases concretas como Guerrero y Mago, quienes tendrán los atributos heredados más
         puntosResistencia() y puntosMagia() respectivamente. Cada uno de ellos deberá inicializarse en 100 al crearse
         el personaje.
         4. Implementar el método mostrarInfo() en las sub-clases, mostrando todos los atributos (heredados y propios)
         5. Implementar el método atacar(), que descontará 20 puntos de Magia/Resistencia.
         6. Implementar el método defender(), que descontará 10 puntos de Magia/Resistencia.
         7. Asegurarse de que se tienen suficientes puntos de Magia/Resistencia para llevar a cabo las acciones.
         De lo contrario, informar al usuario.
         8. Crea 1 personaje de cada tipo y hazlos luchar hasta que se agoten sus puntos.
         9. OPCIONAL: Crea un nuevo método beberPocion() en la clase Personaje, que recupere los puntos perdidos.
         **************************************************************************************************************/

        Personaje p1 = new Guerrero("Arthur");
        Personaje p2 = new Mago("Merlin");

        p1.mostrarInfo();
        p2.mostrarInfo();

        p1.atacar();
        p2.defender();
    }
}