package com.mitocode.trabajofinaljava17.service;

import com.mitocode.trabajofinaljava17.model.Curso;
import com.mitocode.trabajofinaljava17.model.DetalleMatricula;
import com.mitocode.trabajofinaljava17.model.Estudiante;
import com.mitocode.trabajofinaljava17.model.Matricula;

import java.util.List;
import java.util.Map;

public interface IMatriculaService extends ICRUD<Matricula, Integer>{

    public Map<Estudiante, List<Curso>> rela2();

    public List<List<DetalleMatricula>> test();
}
