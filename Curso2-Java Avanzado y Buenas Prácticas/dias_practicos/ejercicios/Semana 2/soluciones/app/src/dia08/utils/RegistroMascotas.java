package dia08.utils;

import dia08.Mascota;

import java.util.*;

public class RegistroMascotas {

    private final List<Mascota<?>> registro;
    private final Random rn;

    public RegistroMascotas() {
        this.registro = new ArrayList<>();
        this.rn = new Random();
    }

    public <T> void agregarMascota(Mascota<T> mascota){
        registro.add(mascota);
    }

    public void generaMascota() {
        String[] nombres = {"Luna", "Max", "Briciola", "Dana", "Roky"};
        List<String> especies = Arrays.asList("Perro", "Gato", "Reptil", "Aves");

        String nombre = nombres[rn.nextInt(nombres.length)];
        int edad = rn.nextInt(15) +1;
        String especie = especies.get(rn.nextInt(especies.size()));
        Mascota<String> mascota = new Mascota<>(nombre, edad, especie);
        agregarMascota(mascota);
    }

    public List<Mascota<?>> buscarPorNombre(String nombre) {
        return registro.stream().filter(m->m.getNombre().equalsIgnoreCase(nombre)).toList();
    }

    public <T> List<Mascota<?>> buscarPorEspecie(T especie) {
        return registro.stream().filter(m->m.getEspecie().equals(especie)).toList();
    }

    public int contarMascotas() {
        return registro.size();
    }
}
