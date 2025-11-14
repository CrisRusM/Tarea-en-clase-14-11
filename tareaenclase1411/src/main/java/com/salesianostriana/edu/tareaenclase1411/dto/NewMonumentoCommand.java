package com.salesianostriana.edu.tareaenclase1411.dto;

public record NewMonumentoCommand(
                                      String codigoPais,
                                      String nombrePais,
                                      String nombreCiudad,
                                      double latitud,
                                      double longitud,
                                      String nombreMonumento,
                                      String descripcion,
                                      String url) {

}
