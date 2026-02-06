package com.salesianostriana.edu.tareaenclase1411.model;

import jakarta.validation.Constraint;

import java.lang.annotation.*;
import java.time.LocalDateTime;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy =DateTimeBetweenValidator.class)
public @interface DateTimeBetween {



    String min();
    String max();
}
