package com.zipcodewilmington.bakery.Controllers;

import com.zipcodewilmington.bakery.Models.Baker;
import com.zipcodewilmington.bakery.Repositories.BakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BakerController {

    @Autowired
    private BakerRepository bakerRepository;

    @GetMapping("/bakers")
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(this.bakerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/bakers/{id}")
    public ResponseEntity<Baker> show(@PathVariable Long id) {
        return new ResponseEntity<>(this.bakerRepository.findOne(id), HttpStatus.OK);
    }

    @PostMapping("/bakers")
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(this.bakerRepository.save(baker), HttpStatus.CREATED);
    }

    @PutMapping("/bakers/{id}")
    public ResponseEntity<Baker> update(@PathVariable Long id, @RequestBody Baker baker) {
        Baker foundBaker = bakerRepository.findOne(id);

        foundBaker.setName(baker.getName());
        foundBaker.setSpecialty(baker.getSpecialty());

        return new ResponseEntity<>(this.bakerRepository.save(foundBaker), HttpStatus.OK);
    }

    @DeleteMapping("/bakers/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        this.bakerRepository.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
