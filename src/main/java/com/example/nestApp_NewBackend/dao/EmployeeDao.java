package com.example.nestApp_NewBackend.dao;

import com.example.nestApp_NewBackend.model.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
