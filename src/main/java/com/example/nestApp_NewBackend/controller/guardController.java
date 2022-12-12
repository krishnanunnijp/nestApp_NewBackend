package com.example.nestApp_NewBackend.controller;

import com.example.nestApp_NewBackend.dao.EmployeeDao;
import com.example.nestApp_NewBackend.dao.GuardDao;
import com.example.nestApp_NewBackend.model.Employee;
import com.example.nestApp_NewBackend.model.Guard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class guardController {
    @Autowired
    GuardDao dao2;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addGuard",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> add(@RequestBody Guard g){
        HashMap<String,String> map = new HashMap<>();
        System.out.println(g.getGuardnumber());
        dao2.save(g);
        map.put("status","success");
        return map;
    }


}
