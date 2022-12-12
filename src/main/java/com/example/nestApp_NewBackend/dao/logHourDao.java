package com.example.nestApp_NewBackend.dao;

import com.example.nestApp_NewBackend.model.logHours;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface logHourDao extends CrudRepository<logHours,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `log_hours` SET `logout`=:logout, `minutes`=:minutes  WHERE `emp_id`=:emp_id AND `date`=:date",nativeQuery = true)
    void updateLog(@Param("logout") String logout,@Param("minutes") Integer minutes,@Param("emp_id") Integer emp_id,@Param("date") String date);

    @Query(value = "SELECT `id`, `date`, `emp_id`, `login`, `logout`, `minutes` FROM `log_hours` WHERE `date` =:date AND `emp_id`=:emp_id",nativeQuery = true)
    List<logHours> searchLog(@Param("date") String date, @Param("emp_id") Integer emp_id);

}
