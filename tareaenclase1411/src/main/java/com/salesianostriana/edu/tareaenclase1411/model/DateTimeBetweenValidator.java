package com.salesianostriana.edu.tareaenclase1411.model;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class DateTimeBetweenValidator implements ConstraintValidator<DateTimeBetween, LocalDateTime> {

    String strMinDate, strMaxDate;

    @Override
    public void initialize(DateTimeBetween constraintAnnotation) {
        strMaxDate= constraintAnnotation.max();
        strMinDate= constraintAnnotation.max();
    }

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext constraintValidatorContext) {
        LocalDateTime minDate= LocalDateTime.parse(strMinDate);
        LocalDateTime maxDate= LocalDateTime.parse(strMaxDate);

        return value != null && value.isAfter(minDate) && value.isBefore(maxDate);
    }
}
