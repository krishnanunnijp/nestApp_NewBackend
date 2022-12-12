package com.example.nestApp_NewBackend.dao;

import com.example.nestApp_NewBackend.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query(value = "SELECT `id`,`designation`, `employee_code`, `mobile_number`, `name`, `password`, `salary`, `user_name` FROM `employee` WHERE `user_name`=:user_name AND `password`=:password",nativeQuery = true)
    List<Employee> passwordCheck(@Param("user_name") String user_name, @Param("password") String password);

    @Query(value = "SELECT `id`, `designation`, `employee_code`, `mobile_number`, `name`, `password`, `salary`, `user_name` FROM `employee` WHERE `employee_code`=:employee_code",nativeQuery = true)
    List<Employee> searchEmployees(@Param("employee_code") Integer employee_code);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `employee` WHERE `id`=:id",nativeQuery = true)
    void deleteEmployee(@Param("id") Integer id);
}
