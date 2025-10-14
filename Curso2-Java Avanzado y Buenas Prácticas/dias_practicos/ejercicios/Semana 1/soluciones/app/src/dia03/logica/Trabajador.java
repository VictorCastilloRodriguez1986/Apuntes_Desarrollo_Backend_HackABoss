package dia03.logica;


public class Trabajador implements Runnable {

    private Estacion estac;
    private String nombre;

    public Trabajador(Estacion estac, String nombre) {
        this.estac = estac;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        //operaciones al azar de ensamblar, de controlar, o de embalar
        estac.ensamblar(nombre);
        try {
            Thread.sleep(1000); // Introducir una pausa para simular un trabajo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        estac.controlar(nombre);
        try {
            Thread.sleep(1000); // Introducir una pausa para simular un trabajo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        estac.embalar(nombre);
        try {
            Thread.sleep(1000); // Introducir una pausa para simular un trabajo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
