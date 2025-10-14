package Simple;

import java.util.List;

public class Monitor {
    public void monitorearItems(List<?> eventos){
        for (Object evento : eventos){
            System.out.println("Evento registrado: " + evento);
        }
    }
}