package dia03;

import java.util.Random;

public class Agente extends Thread{
    private String nombre;

    public Agente(String nombre) {
        this.nombre = nombre;
    }

    // Sobrescribir el metodo run() para definir la tarea del hilo
    @Override
    public void run() {
        // simulo 5 llamadas con duracion random
        for (int i = 1; i <= 5 ; i++) {
            System.out.println(nombre + " está con la llamada " + i + " resolviendo consultas y registrando la información.");
            try{
                // una llamada dura entre 1 y 20 segundos
                Thread.sleep(((new Random().nextInt(20))+1)*1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}