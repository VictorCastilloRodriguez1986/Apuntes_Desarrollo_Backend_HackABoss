public abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;

    public Personaje(String nombre) {
        this.nombre = nombre;
        nivel = 1;
        puntosVida = 100;
    }

    abstract void mostrarInfo();

    abstract void atacar();

    abstract void defender();

    abstract void beberPocion();
}
