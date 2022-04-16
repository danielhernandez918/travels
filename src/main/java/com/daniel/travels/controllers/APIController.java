package com.daniel.travels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.travels.models.Travel;
import com.daniel.travels.services.TravelService;

@RestController
public class APIController {
	
	private final TravelService service;
	
	public APIController(TravelService service) {
		this.service = service;
	}
	
	@GetMapping("/api/travels")
    public List<Travel> index() {
        return service.allTravel();
    }
    
    @PostMapping(value="/api/travels")
    public Travel create(
    		@RequestParam(value="expense") String expense, 
    		@RequestParam(value="vendor") String vendor, 
    		@RequestParam(value="amount") Double amount, 
    		@RequestParam(value="description") String description) {
    	
        Travel travel = new Travel(expense, vendor, amount, description);
        return service.createTravel(travel);
    }
    
    @GetMapping("/api/travels/{id}")
    public Travel show(@PathVariable("id") Long id) {
        Travel travel = service.findTravel(id);
        return travel;
    }
    
    @PutMapping(value="/api/travels/{id}")
    public Travel update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="expense") String expense, 
    		@RequestParam(value="vendor") String vendor, 
    		@RequestParam(value="amount") Double amount,
    		@RequestParam(value="description") String description) {
    	
    	
    	Travel travel = new Travel(expense, vendor, amount, description);
    	travel.setId(id);
    	
        travel = service.updateTravel(travel);
        
        return travel;
    }
    
    @DeleteMapping(value="/api/travels/{id}")
    public void destroy(@PathVariable("id") Long id) {
        service.deleteTravel(id);
    }

}
