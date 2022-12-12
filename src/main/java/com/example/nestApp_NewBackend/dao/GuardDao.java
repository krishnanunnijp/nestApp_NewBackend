package com.example.nestApp_NewBackend.dao;

import com.example.nestApp_NewBackend.model.Guard;
import org.springframework.data.repository.CrudRepository;




public interface GuardDao extends CrudRepository<Guard, Integer> {

}
