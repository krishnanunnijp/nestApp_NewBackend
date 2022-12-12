package com.example.nestApp_NewBackend.controller;

import com.example.nestApp_NewBackend.dao.totLeavesDao;
import com.example.nestApp_NewBackend.model.totLeaves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
public class totLeavesController {

    @Autowired
    totLeavesDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addTotal",consumes = "application/json",produces = "application/json")
    public HashMap<String,String>  addTotal(@RequestBody totLeaves total){
        HashMap<String, String> map = new HashMap<>();
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear());
        total.setYear(localDate.getYear());
        dao.save(total);
        map.put("status","success");
        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchTotal",consumes = "application/json",produces = "application/json")
    public List<totLeaves> searchTotal(@RequestBody totLeaves total){
        return dao.searchTotalLeavesEmployees(total.getEmp_id());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/editTotal",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> editTotal(@RequestBody totLeaves total){
        HashMap<String, String> map = new HashMap<>();
         dao.editLeaves( total.getCasual_leaves(), total.getSick_leave(), total.getSpecial_leave(),   total.getEmp_id());
         map.put("status","success");
        return map;
    }



}
