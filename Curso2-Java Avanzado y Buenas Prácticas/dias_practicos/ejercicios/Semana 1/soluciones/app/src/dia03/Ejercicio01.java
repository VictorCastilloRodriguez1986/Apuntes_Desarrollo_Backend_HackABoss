package dia03;

public class Ejercicio01 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inicio del hilo principal");

        System.out.println("Simulación de un centro de atención al cliente en la que varios agentes de soporte pueden atender llamadas telefónicas concurrentemente");

        // creamos dos hilos con el constructor por parémtros
        Agente agente1 = new Agente("Agente 1");
        Agente agente2 = new Agente("Agente 2");

        // llama al metodo start() para iniciar ambos hilos
        agente1.start();
        agente2.start();

        // Hace que el hilo principal se ponga en "espera" hasta que no acaben los hilos hijos
        agente1.join();
        agente2.join();

        System.out.println("Fin del hilo principal");
    }
}
