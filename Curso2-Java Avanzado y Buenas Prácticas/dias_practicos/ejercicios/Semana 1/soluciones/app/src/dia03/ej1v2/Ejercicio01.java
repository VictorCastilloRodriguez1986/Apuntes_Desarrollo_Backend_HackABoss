package dia03.ej1v2;

import dia03.ej1v2.logica.Agente;
import dia03.ej1v2.logica.Llamada;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Ejercicio01 {
    public static void main(String[] args) {

        /*a BlockingQueue es una interfaz en Java que extiende la interfaz Queue y proporciona métodos
        adicionales para la manipulación segura de colas en un entorno multihilo. */

        /*La principal característica de una BlockingQueue es que incluye mecanismos de bloqueo que
        permiten a los hilos esperar hasta que la cola tenga espacio para agregar elementos o hasta que
        la cola tenga elementos para ser consumidos.*/
        BlockingQueue<Llamada> llamadasQueue = new LinkedBlockingQueue<>();

        // Simular llamadas
        for (int i = 1; i <= 10; i++) {
            Llamada llamada = new Llamada("Cliente" + i, "Consulta" + i);
            llamadasQueue.add(llamada);
        }

        // Crear agentes
        Agente agente1 = new Agente(1, llamadasQueue);
        Agente agente2 = new Agente(2, llamadasQueue);

        // Iniciar agentes
        agente1.start();
        agente2.start();

        // Esperar a que todos los agentes terminen
        try {
            agente1.join();
            agente2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
