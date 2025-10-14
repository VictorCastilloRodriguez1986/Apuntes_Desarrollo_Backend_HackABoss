public class Main {
    public static void main(String[] args) {
        //Abstraccion
        Animal miPerro = new Perro();
        miPerro.hacerSonido();

        //Encapsulamiento
        Auto miAuto = new Auto();
        System.out.println("La velocidad es: " + miAuto.getVelocidad() + " k/h");
        miAuto.acelerar(100);
        System.out.println("La velocidad es: " + miAuto.getVelocidad() + " k/h");

        //Herencia
        Coche miCoche = new Coche();
        miCoche.tocarBocina();
        miCoche.acelerar();

        //Polimorfismo
        Llamada llamada1 = new Llamada();
        llamada1.responder();

        Llamada llamada2 = new Pareja();
        llamada2.responder();

        Llamada llamada3 = new Jefe();
        llamada3.responder();
    }
}