import Interfaces.DispositivoInteligente;
import Interfaces.Vehiculo;

public class Coche implements Vehiculo, DispositivoInteligente {
    @Override
    public void conectarWifi() {
        System.out.println("El coche está acelerando...");
    }

    @Override
    public void acelerar() {
        System.out.println("El coche se ha conectado al WiFi.");
    }
}