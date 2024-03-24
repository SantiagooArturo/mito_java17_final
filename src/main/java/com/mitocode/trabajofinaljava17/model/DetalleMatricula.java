package com.mitocode.trabajofinaljava17.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleMatricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDetalleMatricula;

    @JsonBackReference
    @ManyToOne//muchos detalles pertenecen a una matricula
    @JoinColumn(name = "id_matricula", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLEMATRICULA_MATRICULA"))
    private Matricula matricula;


    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLEMATRICULA_CURSO"))
    private Curso curso;

    @Column(nullable = false)
    private String aula;
}
