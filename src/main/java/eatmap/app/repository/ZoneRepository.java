package eatmap.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eatmap.app.entity.Ville;
import eatmap.app.entity.Zone;



public interface ZoneRepository extends JpaRepository<Zone, Long> {
	List<Zone> findAll();
	Zone findByNomAndVille_Nom(String nomZone, String nomVille);
	Zone findBynom(String nom);
	Zone findByid(Integer id);
	List<Zone> findByVille(Ville ville);

}
