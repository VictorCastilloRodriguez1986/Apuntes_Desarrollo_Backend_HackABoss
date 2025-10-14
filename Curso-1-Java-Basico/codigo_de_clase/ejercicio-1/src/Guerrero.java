public class Guerrero extends Personaje{
    private int puntosResistencia;

    public Guerrero(String nombre) {
        super(nombre);
        puntosResistencia = 100;
    }

    @Override
    void mostrarInfo() {
        System.out.println("----- Datos del Guerrero -----");
        System.out.println("NOMBRE: " + nombre);
        System.out.println("NIVEL: " + nivel);
        System.out.println("PUNTOS DE VIDA: " + puntosVida);
        System.out.println("PUNTOS DE RESISTENCIA: " + puntosResistencia);
    }

    @Override
    void atacar() {
        if (puntosResistencia >= 20) {
            puntosResistencia -= 20;
            System.out.println(nombre + " ataca con su espada [" + puntosResistencia + "]");
        } else {
            System.out.println("Puntos de Resistencia insuficientes.");
        }
    }

    @Override
    void defender() {
        if (puntosResistencia >= 10) {
            puntosResistencia -= 10;
            System.out.println(nombre + " bloquea con su escudo [" + puntosResistencia + "]");
        } else {
            System.out.println("Puntos de Resistencia insuficientes.");
        }
    }

    @Override
    void beberPocion() {
        puntosResistencia = 100;
        System.out.println("¡Puntos de Resistencia recuperados!");
    }
}
