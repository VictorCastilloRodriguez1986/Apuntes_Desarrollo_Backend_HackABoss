package Super;

import java.util.ArrayList;
import java.util.List;

public class Exportador {
    public static void main(String[] args) {
        List<Object> colaDeExportacion = new ArrayList<>();
        agregarExportables(colaDeExportacion);
    }
    public static void agregarExportables(List<? super Documento> cola){
        cola.add(new PDF());
        cola.add(new Word());
        System.out.println("Documentos agregados correctamente!");
    }
}