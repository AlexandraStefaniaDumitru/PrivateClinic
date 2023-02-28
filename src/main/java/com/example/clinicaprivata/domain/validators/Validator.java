package com.example.clinicaprivata.domain.validators;

import com.example.clinicaprivata.domain.exceptions.EmptyStringException;
import com.example.clinicaprivata.domain.exceptions.NegativeNumberException;

public interface Validator<T> {
    void validate(T entity) throws ValidationException, EmptyStringException, NegativeNumberException;
}