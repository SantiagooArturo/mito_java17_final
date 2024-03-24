package com.mitocode.trabajofinaljava17.dto;

import com.mitocode.trabajofinaljava17.model.Estudiante;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {

    @NotNull
    private Integer idMatricula;


    @NotNull
    private LocalDateTime dateMatricula;


    @NotNull
    private Estudiante estudiante;

    @NotNull
    private boolean estadoMatricula;


}
