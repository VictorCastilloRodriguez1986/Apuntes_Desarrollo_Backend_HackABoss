package com.hackaboss.persistence;

import com.hackaboss.entities.Auto;
import jakarta.persistence.EntityManager;
import java.util.List;

public class AutoJPA {
    public void agregarAuto(String descripcion) {
        EntityManager em = ConfigJPA.getEntityManager();
        em.getTransaction().begin();
        em.persist(new Auto(descripcion));
        em.getTransaction().commit();
        em.close();
    }

    public List<Auto> listarAutos() {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            return em.createQuery("FROM Auto", Auto.class).getResultList();
        }
    }

    public Auto consultarAuto(Long id) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            return em.find(Auto.class, id);
        }
    }

    public boolean actualizarAuto(Long id, String descripcion) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            Auto auto = em.find(Auto.class, id);
            if (auto != null) {
                em.getTransaction().begin();
                auto.setDescripcion(descripcion);
                em.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean eliminarAuto(Long id) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            Auto auto = em.find(Auto.class, id);
            if (auto != null) {
                em.getTransaction().begin();
                em.remove(auto);
                em.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        }
    }
}