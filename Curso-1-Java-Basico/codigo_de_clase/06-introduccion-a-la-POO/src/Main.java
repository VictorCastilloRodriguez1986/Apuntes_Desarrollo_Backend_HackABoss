public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("electrico", 1);
        //Pokemon charizard = new Pokemon("fuego", 30);
        //Pokemon squirtle = new Pokemon("agua", 1);

        // Testeando Pikachu
        System.out.println("El nivel inicial de pikachu es: " + pikachu.getNivel());

        for (int i = 0; i < 10; i++) {
            pikachu.atacar();
        }

        System.out.println("El nivel final de pikachu es: " + pikachu.getNivel());
    }
}