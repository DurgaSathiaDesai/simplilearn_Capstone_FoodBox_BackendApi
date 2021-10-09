package com.simplilearn.capstone.foodboxWebApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.capstone.foodboxWebApplication.Entity.userInfo;

@Repository
public interface userInfoRepository extends JpaRepository<userInfo, Long> , CrudRepository<userInfo, Long>
{

}
