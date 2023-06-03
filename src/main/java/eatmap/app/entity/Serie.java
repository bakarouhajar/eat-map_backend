package eatmap.app.entity;

import java.util.List;

import jakarta.persistence.*;



@Entity
public class Serie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column 
	private String nom;
	@OneToMany(mappedBy = "serie")
    private List<Restaurant> restaurants;
}
