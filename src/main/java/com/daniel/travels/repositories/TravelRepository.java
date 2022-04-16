package com.daniel.travels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daniel.travels.models.Travel;

public interface TravelRepository extends CrudRepository<Travel, Long> {
	
    // this method retrieves all the expenses from the database
    List<Travel> findAll();
    // this method finds expenses with descriptions containing the search string
    List<Travel> findByDescriptionContaining(String search);
    // this method counts how many expenses contain a certain string
    Long countByExpenseContaining(String search);
    // this method deletes a expense that starts with a specific title
    Long deleteByExpenseStartingWith(String search);
}
