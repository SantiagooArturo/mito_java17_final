package com.mitocode.trabajofinaljava17.controller;

import com.mitocode.trabajofinaljava17.dto.CursoDTO;
import com.mitocode.trabajofinaljava17.dto.MatriculaDTO;
import com.mitocode.trabajofinaljava17.model.Curso;
import com.mitocode.trabajofinaljava17.model.DetalleMatricula;
import com.mitocode.trabajofinaljava17.model.Estudiante;
import com.mitocode.trabajofinaljava17.model.Matricula;
import com.mitocode.trabajofinaljava17.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {
    private final IMatriculaService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> readAll() throws Exception{
        List<Matricula> list = service.readAll();
        return new ResponseEntity<>(convertToDto(list), HttpStatus.OK);
    }

    //METODO PARA BUSQUEDA MAP<ESTUDIANTE, CURSO> -> CLAVE VALOR
    @GetMapping("/busqueda")
    public ResponseEntity<Map<Estudiante, List<Curso>>> busqueda() throws Exception{
        Map<Estudiante, List<Curso>> map = service.rela2();
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<MatriculaDTO> save(@RequestBody MatriculaDTO matriculaDTO) throws Exception{
        Matricula obj = service.save(objConvertToEntity(matriculaDTO));
        return new ResponseEntity<>(objConvertToDto(obj), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Optional<Matricula> obj = service.readById(id);
        Matricula newObj = obj.get();
        return new ResponseEntity<>(objConvertToDto(newObj), HttpStatus.OK);

    }



    @PostMapping("/{id}")
    public ResponseEntity<MatriculaDTO> update(@RequestBody MatriculaDTO matriculaDTO ,@PathVariable("id") Integer id) throws Exception{
        Matricula obj = service.update(objConvertToEntity(matriculaDTO), id);
        return new ResponseEntity<>(objConvertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    public List<MatriculaDTO> convertToDto(List<Matricula> list){
        List<MatriculaDTO> newList = list.stream().map(e -> modelMapper.map(e, MatriculaDTO.class)).toList();
        return newList;

    }


    public MatriculaDTO objConvertToDto(Matricula obj) {
        MatriculaDTO newObj = modelMapper.map(obj, MatriculaDTO.class);
        return newObj;
    }


    public Matricula objConvertToEntity(MatriculaDTO obj){
        Matricula newObj = modelMapper.map(obj, Matricula.class);
        return newObj;
    }



}
