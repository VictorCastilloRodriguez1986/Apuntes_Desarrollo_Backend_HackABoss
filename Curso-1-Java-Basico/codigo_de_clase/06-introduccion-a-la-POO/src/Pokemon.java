public class Pokemon {
    //Atributos
    private String tipo;
    private int nivel;
    private int experiencia = 0;


    //Constructor
    public Pokemon(String tipo, int nivel) {
        this.tipo = tipo;
        this.nivel = nivel;
    }

    // Getters & Setters
    public int getNivel() {
        return nivel;
    }

    //Métodos
    public void atacar(){
        System.out.println("El pokemon ha utilizado un ataque de tipo " + tipo + "!");
        experiencia = experiencia + 20;
        if(experiencia >= 100){
            subirNivel();
            experiencia = experiencia - 100;
        }
        System.out.println("Experiencia total: " + experiencia);
    }

    public void subirNivel(){
        nivel++;
        System.out.println("El pokemon ha subido al nivel " + nivel + "!");
    }
}
