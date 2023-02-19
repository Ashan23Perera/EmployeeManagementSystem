package com.webfluxdemo.repository;

import com.webfluxdemo.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Integer> {

}
