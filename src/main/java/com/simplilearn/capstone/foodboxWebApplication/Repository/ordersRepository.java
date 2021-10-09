package com.simplilearn.capstone.foodboxWebApplication.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.capstone.foodboxWebApplication.Entity.orders;

@Repository
public interface ordersRepository extends CrudRepository<orders, Long>
{

}
