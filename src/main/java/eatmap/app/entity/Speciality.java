package eatmap.app.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Speciality {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column 
	private String nom;
	@ManyToMany(mappedBy = "specialities")
    private Set<Restaurant> restaurants=new HashSet<>();
	public Speciality() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Speciality(Integer id, String nom, Set<Restaurant> restaurants) {
		super();
		this.id = id;
		this.nom = nom;
		this.restaurants = restaurants;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	

}
