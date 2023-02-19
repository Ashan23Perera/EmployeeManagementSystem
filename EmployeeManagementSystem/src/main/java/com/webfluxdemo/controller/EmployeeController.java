package com.webfluxdemo.controller;

import com.webfluxdemo.entity.Employee;
import com.webfluxdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody Employee e){
        employeeService.create(e);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mono<Employee>> getEmployeeById(@PathVariable("id") Integer id) {
        Mono<Employee> e = employeeService.findById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping
    public Flux<Employee> getAllEmployees(){
        return employeeService.getAll();
    }
}
