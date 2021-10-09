package com.simplilearn.capstone.foodboxWebApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.capstone.foodboxWebApplication.Entity.loginCredentials;

@Repository
public interface loginRepository extends JpaRepository<loginCredentials, Long> , CrudRepository<loginCredentials, Long>
{
	@Query("SELECT c FROM loginCredentials c WHERE c.username = ?1 and c.pword = ?2 and c.accountstatus =?3") 
	loginCredentials findByCredentials(String username,String password,String accStatus);
}
