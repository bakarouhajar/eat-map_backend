package eatmap.app.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eatmap.app.entity.Restaurant;
import eatmap.app.repository.RestaurantRepository;
import eatmap.app.service.Dao;

@Service
public class RestaurantServiceImpl implements Dao<Restaurant> {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant GetByName(String nom) {
        return restaurantRepository.findByNom(nom);
    }

    @Override
    public List<Restaurant> GetAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant GetById(Integer id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public Restaurant Save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void Delete(Integer id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant Update(Integer id, Restaurant restaurant) {
        Restaurant existingRestaurant = restaurantRepository.findById(id).orElse(null);
        if (existingRestaurant != null) {
            // Update the properties of existingRestaurant with the new values from restaurant
            existingRestaurant.setNom(restaurant.getNom());
            existingRestaurant.setAdresse(restaurant.getAdresse());
            existingRestaurant.setLongitude(restaurant.getLongitude());
            existingRestaurant.setLattitude(restaurant.getLattitude());
            existingRestaurant.setNum_tel(restaurant.getNum_tel());
            existingRestaurant.setOpenAt(restaurant.getOpenAt());
            existingRestaurant.setCloseAt(restaurant.getCloseAt());
            existingRestaurant.setSpecialities(restaurant.getSpecialities());
            existingRestaurant.setZone(restaurant.getZone());
            existingRestaurant.setSerie(restaurant.getSerie());
            existingRestaurant.setPictures(restaurant.getPictures());
            existingRestaurant.setUser(restaurant.getUser());

            return restaurantRepository.save(existingRestaurant);
        }
        return null;
    }
}
