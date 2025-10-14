public class Impresora extends Thread{
    @Override
    public void run(){
        for (int i = 1; i <= 10; i++) {
            System.out.println("Imprimiendo página " + i);
        }
    }
}