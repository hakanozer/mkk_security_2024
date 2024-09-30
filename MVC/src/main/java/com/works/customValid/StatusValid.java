package com.works.customValid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = StatusValidConst.class)
public @interface StatusValid {

    String message() default "Not Valid Status";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
