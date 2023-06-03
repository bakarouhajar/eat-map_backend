package eatmap.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eatmap.app.ServiceImpl.SpecialityServiceImp;
import eatmap.app.entity.Speciality;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/specialities")
public class SpecialityController {

    private final SpecialityServiceImp specialityService;

    @Autowired
    public SpecialityController(SpecialityServiceImp specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping
    public ResponseEntity<List<Speciality>> getAllSpecialities() {
        List<Speciality> specialities = specialityService.GetAll();
        return new ResponseEntity<>(specialities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Speciality> getSpecialityById(@PathVariable("id") Long id) {
        Speciality speciality = specialityService.GetById(id);
        if (speciality != null) {
            return new ResponseEntity<>(speciality, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Speciality> addSpeciality(@RequestBody Speciality speciality) {
        Speciality savedSpeciality = specialityService.Save(speciality);
        return new ResponseEntity<>(savedSpeciality, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Speciality> updateSpeciality(
            @PathVariable("id") Long id,
            @RequestBody Speciality speciality) {
        Speciality updatedSpeciality = specialityService.Update(id, speciality);
        if (updatedSpeciality != null) {
            return new ResponseEntity<>(updatedSpeciality, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpeciality(@PathVariable("id") Long id) {
        specialityService.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}