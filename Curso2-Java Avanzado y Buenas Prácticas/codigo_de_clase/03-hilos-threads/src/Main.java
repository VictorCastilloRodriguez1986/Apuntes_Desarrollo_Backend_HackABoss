public class Main {
    static volatile boolean hayGanador = false;
    public static void main(String[] args) {
        Thread cocheRojo = new Thread(new Coche("\uD83D\uDE97 Coche Rojo"));
        Thread cocheAzul = new Thread(new Coche("\uD83D\uDE99 Coche Azul"));

        cocheRojo.start();
        cocheAzul.start();
    }
}