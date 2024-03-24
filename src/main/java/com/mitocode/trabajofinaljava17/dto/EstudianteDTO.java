package com.mitocode.trabajofinaljava17.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {

    private Integer idEstudiante;

    @NotBlank
    @NotEmpty
    @NotNull
    private String nombreEstudiante;

    @NotBlank
    @NotEmpty
    @NotNull
    private String apellidoEstudiante;

    @NotBlank
    @NotEmpty
    @NotNull
    private String dniEstudiante;


    @NotBlank
    @NotEmpty
    @NotNull
    private Integer edadEstudiante;


}
