package com.mitocode.trabajofinaljava17.service;

import com.mitocode.trabajofinaljava17.exception.ModelNotFoundException;
import com.mitocode.trabajofinaljava17.model.Estudiante;
import com.mitocode.trabajofinaljava17.repo.IEstudianteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements IEstudianteService{
    private final IEstudianteRepo repo;
    @Override
    public Estudiante save(Estudiante estudiante) throws Exception {
        return repo.save(estudiante);
    }

    @Override
    public Estudiante update(Estudiante estudiante, Integer integer) throws Exception {
        repo.findById(integer).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + integer));
        estudiante.setIdEstudiante(integer);
        return repo.save(estudiante);
    }

    @Override
    public List<Estudiante> readAll() throws Exception {

        Comparator<Estudiante> estudianteComparator = Comparator.comparing(Estudiante::getEdad);
        List<Estudiante> estudiantesOrdenados = repo.findAll();
        return estudiantesOrdenados.stream().sorted(estudianteComparator).collect(Collectors.toList());
    }

    @Override
    public Optional<Estudiante> readById(Integer id) throws Exception {
        return Optional.of(repo.findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id)));
    }

    @Override
    public void delete(Integer integer) throws Exception {
        repo.findById(integer).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + integer));
        repo.deleteById(integer);
    }
}
