package com.mitocode.trabajofinaljava17.controller;

import com.mitocode.trabajofinaljava17.dto.CursoDTO;
import com.mitocode.trabajofinaljava17.model.Curso;
import com.mitocode.trabajofinaljava17.model.Curso;
import com.mitocode.trabajofinaljava17.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {
    private final ICursoService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> readAll() throws Exception{
        List<Curso> list = service.readAll();
        return new ResponseEntity<>(convertToDto(list), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> save(@RequestBody CursoDTO cursoDTO) throws Exception{
        Curso obj = service.save(objConvertToEntity(cursoDTO));
        return new ResponseEntity<>(objConvertToDto(obj), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Optional<Curso> obj = service.readById(id);
        Curso newObj = obj.get();
        return new ResponseEntity<>(objConvertToDto(newObj), HttpStatus.OK);

    }

    @PostMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@RequestBody CursoDTO cursoDTO ,@PathVariable("id") Integer id) throws Exception{
        Curso obj = service.update(objConvertToEntity(cursoDTO), id);
        return new ResponseEntity<>(objConvertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    public List<CursoDTO> convertToDto(List<Curso> list){
        List<CursoDTO> newList = list.stream().map(e -> modelMapper.map(e, CursoDTO.class)).toList();
        return newList;

    }


    public CursoDTO objConvertToDto(Curso obj) {
        CursoDTO newObj = modelMapper.map(obj, CursoDTO.class);
        return newObj;
    }


    public Curso objConvertToEntity(CursoDTO obj){
        Curso newObj = modelMapper.map(obj, Curso.class);
        return newObj;
    }

}
