package com.example.nestApp_NewBackend.controller;

import com.example.nestApp_NewBackend.dao.EmployeeDao;
import com.example.nestApp_NewBackend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class employeeController {
    @Autowired
    EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> add(@RequestBody Employee e){
        HashMap<String,String> map = new HashMap<>();
        dao.save(e);
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> login(@RequestBody Employee e){
        HashMap<String, String> map = new HashMap<String, String>();
        List<Employee> emp= dao.passwordCheck(e.getUserName(),e.getPassword());
        if (emp.size() != 0) {
            map.put("id",String.valueOf( emp.get(0).getId()));
            map.put("status","success");
            map.put("employeeCode",String.valueOf( emp.get(0).getEmployeeCode()));
        }else {
            map.put("status","failed");
        }
        return map;
    }
}
