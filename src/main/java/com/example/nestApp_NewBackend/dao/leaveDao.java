package com.example.nestApp_NewBackend.dao;

import com.example.nestApp_NewBackend.model.Leaves;
import org.springframework.data.repository.CrudRepository;

public interface leaveDao extends CrudRepository<Leaves,Integer> {

}
