import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        /***** INTERFACES FUNCIONALES *****/
        //Consumer
        Consumer<String> mostrarMensaje = mensaje -> System.out.println("Mensaje: " + mensaje);
        mostrarMensaje.accept("Hackaboss");

        //Supplier
        Supplier<Double> generarAleatorio = () -> Math.random()*100;
        double d = generarAleatorio.get();
        System.out.println("Número aleatorio: " + (int)d);

        //Predicate
        Predicate<Integer> esPar = num -> num % 2 == 0;
        System.out.println(esPar.test(2));
        System.out.println(esPar.test(7));

        //Function
        Function<String,Integer> contarLetras = texto -> texto.length();
        int cantidad = contarLetras.apply("Hackaboss");
        System.out.println("Cantidad de letras: " + cantidad);

        //MiInterfazFuncional
        MiInterfazFuncional mif = () -> System.out.println("Mi primera interfaz funcional!");
        mif.play();

        /***** REFERENCIAS A MÉTODOS *****/
        // Con Lambda
        Consumer<String> imprimir = x -> System.out.println(x);
        imprimir.accept("Hackaboss");

        // Con Double Colon operator
        Consumer<String> imprimir2 = System.out::println;
        imprimir.accept("Hackaboss");
    }
}