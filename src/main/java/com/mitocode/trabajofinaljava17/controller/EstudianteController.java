package com.mitocode.trabajofinaljava17.controller;

import com.mitocode.trabajofinaljava17.dto.EstudianteDTO;
import com.mitocode.trabajofinaljava17.model.Estudiante;
import com.mitocode.trabajofinaljava17.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {
    private final IEstudianteService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> readAll() throws Exception{
        List<EstudianteDTO> list = convertToDto(service.readAll());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Estudiante> save(@RequestBody EstudianteDTO estudianteDTO) throws Exception{
        Estudiante obj = objConvertToEntity(estudianteDTO);
        return new ResponseEntity<>(service.save(obj), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Optional<Estudiante> obj = service.readById(id);
        Estudiante newObj = obj.get();
        return new ResponseEntity<>(objConvertToDto(newObj), HttpStatus.OK);

    }

    @PostMapping("/{id}")
    public ResponseEntity<EstudianteDTO> update(@RequestBody EstudianteDTO estudianteDTO ,@PathVariable("id") Integer id) throws Exception{
        Estudiante obj = service.update(objConvertToEntity(estudianteDTO), id);
        return new ResponseEntity<>(objConvertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    public List<EstudianteDTO> convertToDto(List<Estudiante> list){
        List<EstudianteDTO> newList = list.stream().map(e -> modelMapper.map(e, EstudianteDTO.class)).toList();
        return newList;

    }


    public EstudianteDTO objConvertToDto(Estudiante obj) {
        EstudianteDTO newObj = modelMapper.map(obj, EstudianteDTO.class);
        return newObj;
    }


    public Estudiante objConvertToEntity(EstudianteDTO obj){
        Estudiante newObj = modelMapper.map(obj, Estudiante.class);
        return newObj;
    }
}
