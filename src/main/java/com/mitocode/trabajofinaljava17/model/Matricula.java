package com.mitocode.trabajofinaljava17.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatricula;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false, foreignKey = @ForeignKey(name = "FK_MATRICULA_ESTUDIANTE"))
    private Estudiante estudiante;

    @Column(nullable = false)
    private boolean estado;


    //el oneToMany no genera una columna es solo una asiacion logica
    @JsonManagedReference
    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)//en el mapped by va el nombre del atributo por el cual se enlaza en la entidad DetalleMatricula
    private List<DetalleMatricula> detalles;




}
