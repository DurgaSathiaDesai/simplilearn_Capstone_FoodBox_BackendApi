package com.simplilearn.capstone.foodboxWebApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.capstone.foodboxWebApplication.Entity.foodOffers;

@Repository
public interface foodoffersRepository extends JpaRepository<foodOffers, Long> , CrudRepository<foodOffers, Long>
{
	@Query("SELECT o FROM foodOffers o WHERE o.offername = ?1") 
	foodOffers checkOffersByName(String name);
}
