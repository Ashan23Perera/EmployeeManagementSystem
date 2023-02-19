package com.webfluxdemo.service;

import com.webfluxdemo.exception.ValidationException;
import com.webfluxdemo.utils.Validation;
import com.webfluxdemo.entity.Employee;
import com.webfluxdemo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private Validation validation;

    public void create(Employee e)  {
        try {
            validation.employeeValidation(e);
            employeeRepository.save(e).subscribe();
        } catch (ValidationException ex) {
            log.error(ex.toString());
        }
    }

    public Mono<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    public Flux<Employee> getAll(){
        return employeeRepository.findAll();
    }
}
