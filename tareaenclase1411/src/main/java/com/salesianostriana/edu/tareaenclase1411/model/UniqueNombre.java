package com.salesianostriana.edu.tareaenclase1411.model;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UniqueNobreValidator.class)
public @interface UniqueNombre {
}
