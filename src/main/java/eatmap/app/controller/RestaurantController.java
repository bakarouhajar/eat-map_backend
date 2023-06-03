package eatmap.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eatmap.app.ServiceImpl.RestaurantServiceImpl;
import eatmap.app.entity.Restaurant;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/restaurant")

public class RestaurantController {
	 @Autowired
	    RestaurantServiceImpl restaurantimpl;
	 
	 @PostMapping
	    public Restaurant Save(@RequestBody Restaurant restaurant) {
	    	return restaurantimpl.Save(restaurant);
	    }
	 
	    @DeleteMapping("/{id}")
	    public void Delete(@PathVariable Integer id) {
	    	restaurantimpl.Delete(id);
	    }
	    
	    @PutMapping("/{id}")
	    public Restaurant Update(@PathVariable Integer id,@RequestBody Restaurant restaurant) {
	    	return restaurantimpl.Update(id, restaurant);
	    }
	    
	    @GetMapping
	    public List<Restaurant> getAll(){
	    	return restaurantimpl.GetAll();
	    }
}