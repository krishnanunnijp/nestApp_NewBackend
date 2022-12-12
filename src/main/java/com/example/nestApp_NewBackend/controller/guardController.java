package com.example.nestApp_NewBackend.controller;
import com.example.nestApp_NewBackend.dao.GuardDao;
import com.example.nestApp_NewBackend.model.Employee;
import com.example.nestApp_NewBackend.model.Guard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/loginGuard",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> login(@RequestBody Guard g){
        HashMap<String, String> map = new HashMap<String, String>();
        List<Guard> emp= dao2.passwordCheck(g.getUserName(),g.getPassword());
        if (emp.size() != 0) {
            map.put("id",String.valueOf( emp.get(0).getId()));
            map.put("status","success");
        }else {
            map.put("status","failed");
        }
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewGuard")
    public List<Guard> viewGuard(){
        return (List<Guard>) dao2.findAll();
    }


}