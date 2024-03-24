package com.mitocode.trabajofinaljava17.service;

import com.mitocode.trabajofinaljava17.exception.ModelNotFoundException;
import com.mitocode.trabajofinaljava17.model.Curso;
import com.mitocode.trabajofinaljava17.repo.ICursoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements ICursoService{
    private final ICursoRepo repo;
    @Override
    public Curso save(Curso curso) throws Exception {
        return repo.save(curso);
    }

    @Override
    public Curso update(Curso curso, Integer integer) throws Exception {
        repo.findById(integer).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + integer));
        curso.setIdCurso(integer);
        return repo.save(curso);
    }

    @Override
    public List<Curso> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Optional<Curso> readById(Integer integer) throws Exception {
        return Optional.of(repo.findById(integer).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + integer)));
    }

    @Override
    public void delete(Integer integer) throws Exception {
        repo.findById(integer).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + integer));
        repo.deleteById(integer);
    }
}
