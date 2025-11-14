package com.salesianostriana.edu.tareaenclase1411.error;

public class MonumentoNotFoundException extends RuntimeException {
    public MonumentoNotFoundException(String message) {
        super(message);
    }

    public MonumentoNotFoundException(Long id){
        super("No se ha encontrado un monumento con este ID: %d".formatted(id));
    }

    public MonumentoNotFoundException(){
        super("No hay monumentos con esos requisitos de búsqueda.");
    }

}
