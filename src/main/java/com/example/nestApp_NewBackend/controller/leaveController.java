package com.example.nestApp_NewBackend.controller;

import com.example.nestApp_NewBackend.dao.leaveDao;
import com.example.nestApp_NewBackend.model.Leaves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        LocalDate from = LocalDate.parse(String.valueOf(leaves.getFrom()));
        LocalDate to = LocalDate.parse(String.valueOf(leaves.getTo()));
        long diffInDays = ChronoUnit.DAYS.between(from, to);
        leaves.setDays((int) diffInDays);
        dao.save(leaves);
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/editLeaves",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> editLeaves(@RequestBody Leaves leaves){

        HashMap<String,String> map = new HashMap<>();
        dao.updateLeave(leaves.getStatus(),leaves.getRemarks(),leaves.getId());
        map.put("status","success");
        return map;
    }


}
