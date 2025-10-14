package dia08;

import dia08.utils.RegistroMascotas;

public class Ejercicio01 {
    public static void main(String[] args) {
        RegistroMascotas registro = new RegistroMascotas();

        // generamos 5 mascotas
        for (int i = 0; i < 5; i++) {
            registro.generaMascota();
        }

        registro.agregarMascota(new Mascota<>("Lula", 2, "Perro"));
        registro.agregarMascota(new Mascota<>("Fufi", 3, "Gato"));

        // Buscar Mascotas por Nombre o Especie
        System.out.println("Mascotas con nombre Briciola:" + registro.buscarPorNombre("Briciola"));
        System.out.println("Mascotas de especie perro:" + registro.buscarPorEspecie("Perro"));

        // Contar la Cantidad Total de Mascotas Registradas
        System.out.println("Número mascotas: " + registro.contarMascotas());

    }
}
