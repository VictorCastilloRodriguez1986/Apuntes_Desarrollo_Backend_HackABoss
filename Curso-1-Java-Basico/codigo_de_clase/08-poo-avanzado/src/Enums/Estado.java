package Enums;

public enum Estado {
    PENDIENTE("El pedido está pendiente"),
    ENVIADO("El pedido ha sido enviado"),
    ENTREGADO("El pedido ha sido entregado");

    private final String descripcion;

    Estado(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
