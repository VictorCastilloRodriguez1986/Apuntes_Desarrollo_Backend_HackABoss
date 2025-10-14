public class Mago extends Personaje {
    private int puntosMagia;

    public Mago(String nombre) {
        super(nombre);
        puntosMagia = 100;
    }

    @Override
    void mostrarInfo() {
        System.out.println("----- Datos del Mago -----");
        System.out.println("NOMBRE: " + nombre);
        System.out.println("NIVEL: " + nivel);
        System.out.println("PUNTOS DE VIDA: " + puntosVida);
        System.out.println("PUNTOS DE MAGIA: " + puntosMagia);
    }

    @Override
    void atacar() {
        if (puntosMagia >= 20) {
            puntosMagia -= 20;
            System.out.println(nombre + " lanza un hechizo [" + puntosMagia + "]");
        } else {
            System.out.println("Puntos de Magia insuficientes.");
        }
    }

    @Override
    void defender() {
        if (puntosMagia >= 10) {
            puntosMagia -= 10;
            System.out.println(nombre + " crea una barrera de fuego [" + puntosMagia + "]");
        } else {
            System.out.println("Puntos de Magia insuficientes.");
        }
    }

    @Override
    void beberPocion() {
        puntosMagia = 100;
        System.out.println("¡Puntos de Magia recuperados!");
    }
}