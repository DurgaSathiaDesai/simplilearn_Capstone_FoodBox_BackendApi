package com.simplilearn.capstone.foodboxWebApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.capstone.foodboxWebApplication.Entity.fooditems;

@Repository
public interface fooditemRepository extends JpaRepository<fooditems, Long> , CrudRepository<fooditems, Long>
{
	@Query("SELECT f FROM fooditems f WHERE f.foodstatus = ?1") 
    List<fooditems> getAllAvailableFooditems(String status);
    
}
