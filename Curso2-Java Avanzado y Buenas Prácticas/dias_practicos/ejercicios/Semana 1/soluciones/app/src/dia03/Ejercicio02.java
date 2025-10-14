package dia03;

import dia03.logica.Estacion;
import dia03.logica.Trabajador;

public class Ejercicio02 {
    public static void main(String[] args) {
        Estacion estac = new Estacion();
        //creamos varios hilos
        int personas = 3;
        for (int i = 1; i <= personas; i++) {
            Thread persona = new Thread(new Trabajador(estac, "Trabajador " + i));
            persona.start();
        }
    }
}
