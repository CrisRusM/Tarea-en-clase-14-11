package com.salesianostriana.edu.tareaenclase1411.controller;

import com.salesianostriana.edu.tareaenclase1411.dto.EditMonumentoCommand;
import com.salesianostriana.edu.tareaenclase1411.model.Monumento;
import com.salesianostriana.edu.tareaenclase1411.service.MonumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monument")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoService monumentoService;

    @GetMapping
    public List<Monumento> getAll(){
        return monumentoService.fidnAll();
    }

    @GetMapping("/{id}")
    public Monumento getById(@PathVariable Long id){
        return monumentoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Monumento> create(@RequestBody EditMonumentoCommand cmd){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(monumentoService.save(cmd));
    }

    @PutMapping("/{id}")
    public Monumento edit(@RequestBody EditMonumentoCommand cmd, @PathVariable Long id){
        return monumentoService.edit(cmd,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        monumentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
