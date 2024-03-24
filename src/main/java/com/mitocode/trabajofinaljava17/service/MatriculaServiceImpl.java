package com.mitocode.trabajofinaljava17.service;

import com.mitocode.trabajofinaljava17.exception.ModelNotFoundException;
import com.mitocode.trabajofinaljava17.model.Curso;
import com.mitocode.trabajofinaljava17.model.DetalleMatricula;
import com.mitocode.trabajofinaljava17.model.Estudiante;
import com.mitocode.trabajofinaljava17.model.Matricula;
import com.mitocode.trabajofinaljava17.repo.IDetalleMatriculaRepo;
import com.mitocode.trabajofinaljava17.repo.IMatriculaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl implements IMatriculaService{

    private final IMatriculaRepo repo;
    private final IDetalleMatriculaRepo repo2;

    @Override
    public Matricula save(Matricula matricula) throws Exception {
        return repo.save(matricula);
    }

    @Override
    public Matricula update(Matricula matricula, Integer integer) throws Exception {
        repo.findById(integer).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + integer));
        matricula.setIdMatricula(integer);
        return repo.save(matricula);
    }

    @Override
    public List<Matricula> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Optional<Matricula> readById(Integer integer) throws Exception {
        return Optional.of(repo.findById(integer).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND:  " + integer)));
    }

    @Override
    public void delete(Integer integer) throws Exception {
        repo.findById(integer).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + integer));
        repo.deleteById(integer);
    }


   @Override
    public Map<Estudiante, List<Curso>> rela2() {
        List<Matricula> listM = repo.findAll();

        List<DetalleMatricula> deta = repo2.findAll();

        Map<Estudiante, List<Curso>> map1 = new LinkedHashMap<>();

       for(Matricula list: listM){
            //for(DetalleMatricula det: deta){
                map1.put(list.getEstudiante(), deta.stream().map(e -> e.getCurso()).toList());
            //}
        }
        return map1;
    }




    @Override
    public List<List<DetalleMatricula>> test() {
        List<Matricula> listM = repo.findAll();
        List<List<DetalleMatricula>> deta = new ArrayList<>();
        for (Matricula matricula : listM) {
            List<DetalleMatricula> detalles = matricula.getDetalles();
            deta.add(detalles);

        }
        return deta;
    }

//


}
