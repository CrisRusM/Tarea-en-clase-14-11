package com.salesianostriana.edu.tareaenclase1411.model;

import com.salesianostriana.edu.tareaenclase1411.repository.MonumentoRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class UniqueNobreValidator implements ConstraintValidator<UniqueNombre, String> {

     @Autowired
     private MonumentoRepository repository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !repository.existsByNombreMonumento(s.toLowerCase());
    }
}
