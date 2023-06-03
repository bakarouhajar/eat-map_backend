package eatmap.app.entity;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;



@Entity
public class Restaurant {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private String nom ;
	@Column
	private String adresse ;
	@Column
	private String longitude ;
	@Column
	private String lattitude;
	@Column 
	private String num_tel;
	@Column
    private LocalTime openAt;
	@Column
    private LocalTime closeAt;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
        name = "restaurant_speciality",
        joinColumns = @JoinColumn(name = "restaurant_id"),
        inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities=new HashSet<>();
	 @ManyToOne
	    @JoinColumn(name = "zone_id")
	    private Zone zone;
	 @ManyToOne
	    @JoinColumn(name = "serie_id")
	    private Serie serie;
	 @JsonIgnore
	 @OneToMany(mappedBy = "restaurant")
	    private List<Picture> pictures;
	 @ManyToOne
	 @JoinColumn(name = "user_id")
	    private User user ;
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(Long id, String nom, String adresse, String longitude, String lattitude, String num_tel,
			LocalTime openAt, LocalTime closeAt, Set<Speciality> specialities, Zone zone, Serie serie,
			List<Picture> pictures, User user) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.longitude = longitude;
		this.lattitude = lattitude;
		this.num_tel = num_tel;
		this.openAt = openAt;
		this.closeAt = closeAt;
		this.specialities = specialities;
		this.zone = zone;
		this.serie = serie;
		this.pictures = pictures;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLattitude() {
		return lattitude;
	}
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}
	public String getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}
	public LocalTime getOpenAt() {
		return openAt;
	}
	public void setOpenAt(LocalTime openAt) {
		this.openAt = openAt;
	}
	public LocalTime getCloseAt() {
		return closeAt;
	}
	public void setCloseAt(LocalTime closeAt) {
		this.closeAt = closeAt;
	}
	public Set<Speciality> getSpecialities() {
		return specialities;
	}
	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public List<Picture> getPictures() {
		return pictures;
	}
	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	 
}
