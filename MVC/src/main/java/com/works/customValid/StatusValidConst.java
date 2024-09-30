package com.works.customValid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class StatusValidConst implements ConstraintValidator<StatusValid, String> {

    String[] arr = {"user", "admin"};
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Arrays.asList(arr).contains(value);
    }

}
