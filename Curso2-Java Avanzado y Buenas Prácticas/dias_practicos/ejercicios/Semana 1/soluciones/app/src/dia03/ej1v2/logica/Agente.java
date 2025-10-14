package dia03.ej1v2.logica;

import java.util.concurrent.BlockingQueue;

public class Agente extends Thread {
    private int id;
    private BlockingQueue<Llamada> llamadasQueue;

    public Agente(int id, BlockingQueue<Llamada> llamadasQueue) {
        this.id = id;
        this.llamadasQueue = llamadasQueue;
    }

    @Override
    public void run() {
        Llamada llamada = null;
        while (true) {
            try {
                // Esperar a recibir una llamada
                llamada = llamadasQueue.take();
                atenderLlamada(llamada);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println(e);
            }

            if (llamadasQueue.isEmpty()) {
                // Si no hay más llamadas en la cola, salimos del bucle
                break;
            }
        }
    }

    private void atenderLlamada(Llamada llamada) {
        System.out.println("Agente " + id + " atendiendo llamada de " + llamada.getCliente() +
                " - Consulta: " + llamada.getConsulta());
        // Lógica para resolver la consulta
        System.out.println("Agente " + id + " resolvió la consulta de " + llamada.getCliente());
    }

}
