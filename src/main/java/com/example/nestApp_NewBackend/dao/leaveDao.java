package com.example.nestApp_NewBackend.dao;

import com.example.nestApp_NewBackend.model.Leaves;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface leaveDao extends CrudRepository<Leaves,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaves` SET `status`=:status, `remarks` =:remarks WHERE `id`=:id",nativeQuery = true)
    void updateLeave(@Param("status") Integer status,@Param("remarks") String remarks,@Param("id") Integer id);

}
