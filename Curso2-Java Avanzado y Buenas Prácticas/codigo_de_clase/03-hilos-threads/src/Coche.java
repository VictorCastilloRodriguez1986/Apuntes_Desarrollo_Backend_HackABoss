public class Coche implements Runnable{
    private String nombre;

    public Coche(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if(Main.hayGanador){
                return;
            }
        System.out.println(nombre + " completa vuelta " + i);
        }
        Main.hayGanador = true;
        System.out.println("\uD83C\uDFC6" + nombre + " gana la carrera!");
    }
}
