package com.daniel.travels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;

//import java.util.ArrayList;

//import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniel.travels.models.Travel;
import com.daniel.travels.services.TravelService;


@Controller
public class TravelController {
	@Autowired
	TravelService travelService;
	
	@GetMapping("/travels/{travelId}") 
    public String index(Model model, @PathVariable("travelId") Long travelId) {
//		System.out.print(travelId);
		Travel travel = travelService.findTravel(travelId);
//		System.out.println(travel);
		model.addAttribute("travel", travel);
        
		return "show.jsp";
	}
	
    @GetMapping("/travels")
    public String index(Model model, @ModelAttribute("travel") Travel travel) {
//        List<Travel> travels = travelService.allTravel();
        model.addAttribute("travels", travelService.allTravel());
//        Travel emptyTravel = new Travel();
//        model.addAttribute("travel",emptyTravel);
		return "all.jsp";
	}
    @RequestMapping("/travels/create")
    public String create(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		model.addAttribute("travels", travelService.allTravel());
    		return "all.jsp";
    	}
    	else {
    		travelService.createTravel(travel);
    		return "redirect:/travels";
    	}
    }
    
    @GetMapping("/travels/edit/{travelId}")
    public String edit(Model model, @PathVariable("travelId") Long travelId)  {
		Travel travel = travelService.findTravel(travelId);
		model.addAttribute("travel", travel);
		return "edit.jsp";
	}
    
    @PutMapping(value="/travels/{id}")
    public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            travelService.updateTravel(travel);
            return "redirect:/travels";
        }
    }
    
    @DeleteMapping("/travels/{id}")
    public String destroy(@PathVariable("id") Long id) {
        travelService.deleteTravel(id);
        return "redirect:/travels";
    }
    
    
}

