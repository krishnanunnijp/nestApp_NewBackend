package com.example.nestApp_NewBackend.controller;

import com.example.nestApp_NewBackend.dao.leaveDao;
import com.example.nestApp_NewBackend.model.Leaves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class leaveController {

    @Autowired
    leaveDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLeaves",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> addLeaves(@RequestBody Leaves leaves){

        HashMap<String,String> map = new HashMap<>();
        System.out.println(leaves.toString());
        dao.save(leaves);
        map.put("status","success");
        return map;
    }


}
