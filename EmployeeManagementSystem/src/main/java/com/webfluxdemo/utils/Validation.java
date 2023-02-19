package com.webfluxdemo.utils;

import com.webfluxdemo.exception.ValidationException;
import com.webfluxdemo.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class Validation {
    public void employeeValidation(Employee e) throws ValidationException {
        if (e!= null && (e.getEmailId().isEmpty() || e.getFirstName().isEmpty() || e.getLastName().isEmpty() || e.getSalary() == null)){
            throw new ValidationException("Employee fields should not empty " + e);
        }
    }
}
