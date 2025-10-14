package com.hackaboss;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        //Crea una fábrica de EntityManager usando la unidad de persistencia “miUnidad”
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidad");
        // Crea un EntityManager que usaremos para interactuar con la BD
        EntityManager em = emf.createEntityManager();

        // Inicia una transacción
        em.getTransaction().begin();
        Usuario u = new Usuario("Nahuel");
        em.persist(u);
        // Confirma los cambios
        em.getTransaction().commit();

        // Libera los recursos
        em.close();
        emf.close();
    }
}