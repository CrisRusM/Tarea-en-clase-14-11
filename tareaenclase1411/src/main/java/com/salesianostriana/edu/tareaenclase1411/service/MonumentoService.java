package com.salesianostriana.edu.tareaenclase1411.service;

import com.salesianostriana.edu.tareaenclase1411.dto.NewMonumentoCommand;
import com.salesianostriana.edu.tareaenclase1411.error.MonumentoNotFoundException;
import com.salesianostriana.edu.tareaenclase1411.model.Monumento;
import com.salesianostriana.edu.tareaenclase1411.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentoService {
    private final MonumentoRepository monumentoRepository;

    public List<Monumento> fidnAll(){
        List<Monumento> result = monumentoRepository.findAll();
        if(result.isEmpty()){
            throw new MonumentoNotFoundException();
        }
        return result;
    }

    public Monumento findById(Long id){
        return monumentoRepository.findById(id)
                .orElseThrow(()->new MonumentoNotFoundException(id));
    }

    public Monumento save (NewMonumentoCommand monumento){
        return monumentoRepository.save(
                Monumento.builder()
                        .codigoPais(monumento.codigoPais())
                        .nombrePais(monumento.nombrePais())
                        .nombreCiudad(monumento.nombreCiudad())
                        .latitud(monumento.latitud())
                        .longitud(monumento.longitud())
                        .nombreMonumento(monumento.nombreMonumento())
                        .descripcion(monumento.descripcion())
                        .build()
        );
    }

    /*public Monumento edit(NewMonumentoCommand monumento, Long id){

    }*/

}
