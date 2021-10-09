package com.simplilearn.capstone.foodboxWebApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.capstone.foodboxWebApplication.Entity.cuisines;

@Repository
public interface cuisineRepository extends JpaRepository<cuisines, Long> , CrudRepository<cuisines, Long>
{
	@Query("SELECT c FROM cuisines c WHERE c.availstatus = ?1") 
    List<cuisines> getAllAvailableCuisines(String status);
    
    @Query("SELECT c FROM cuisines c WHERE c.cuisinename = ?1") 
     cuisines checkCuisineByName(String name);
}
