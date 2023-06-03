package eatmap.app.entity;

import jakarta.persistence.*;

@Entity
public class Picture {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column 
	private String url;
	@ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Picture(Long id, String url, Restaurant restaurant) {
		super();
		this.id = id;
		this.url = url;
		this.restaurant = restaurant;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
}
