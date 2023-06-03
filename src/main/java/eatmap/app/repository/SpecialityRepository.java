package eatmap.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eatmap.app.entity.Speciality;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    Speciality findByNom(String nom);
}