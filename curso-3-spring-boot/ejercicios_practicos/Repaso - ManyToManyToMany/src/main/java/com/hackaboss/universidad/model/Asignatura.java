package com.hackaboss.universidad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToMany(mappedBy = "asignaturas")
    @JsonIgnore
    private Set<Profesor> profesores = new HashSet<>();
    @ManyToMany
    private Set<Carrera> carreras = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asignatura that)) return false;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}