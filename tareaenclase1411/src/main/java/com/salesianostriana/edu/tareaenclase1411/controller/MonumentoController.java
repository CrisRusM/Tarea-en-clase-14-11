package com.salesianostriana.edu.tareaenclase1411.controller;

import com.salesianostriana.edu.tareaenclase1411.dto.EditMonumentoCommand;
import com.salesianostriana.edu.tareaenclase1411.model.Monumento;
import com.salesianostriana.edu.tareaenclase1411.service.MonumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monument")
@RequiredArgsConstructor
@Tag(name = "Controller de Monumento", description = "Es el controller que tiene los métodos de los monumentos")
public class MonumentoController {

    private final MonumentoService monumentoService;

    @Operation(description = "Método para ver todos los monumentos.")
    @GetMapping
    @ApiResponse(responseCode = "200",
            description = "Se han encontrado los monumentos del repositorio.")
    @ApiResponse(responseCode = "404",
            description = "No se han encontrado los monumentos.")
    public List<Monumento> getAll(){
        return monumentoService.fidnAll();
    }

    @ApiResponse(responseCode = "404",
            description = "No se ha encontrado este monumento",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProblemDetail.class),
            examples = @ExampleObject(
                value = """
                        {
                          "type": "about:blank",
                          "title": "Monumento no encontrado.",
                          "status": 404,
                          "detail": "No se ha encontrado un monumento con este ID: 40",
                          "instance": "/monument/40"
                        }
                        """
                )
            )
    )
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
