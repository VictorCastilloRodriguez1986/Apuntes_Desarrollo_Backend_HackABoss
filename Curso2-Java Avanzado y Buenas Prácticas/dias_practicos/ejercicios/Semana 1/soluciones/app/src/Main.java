import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Repaso return implicito funciones lambda
        List<String> nombres = new ArrayList<>();
        nombres.add("Stefano");
        nombres.add("Sara");
        nombres.add("Leo");

        // Quiero filtrar los nombres que empiezan por "S"
        System.out.println("Nombres que empiezan por 'S': " + nombres.stream().filter((nombre)->{return nombre.startsWith("S");}).toList() );
        System.out.println("Nombres que empiezan por 'S': " + nombres.stream().filter(nombre -> nombre.startsWith("S")).toList());
    }
}
