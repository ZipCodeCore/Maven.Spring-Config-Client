package com.zipcodewilmington.bakery.Controllers;

import com.zipcodewilmington.bakery.Models.Muffin;
import com.zipcodewilmington.bakery.Repositories.MuffinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MuffinController {

    @Autowired
    private MuffinRepository muffinRepository;

    @GetMapping("/muffins")
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(this.muffinRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/muffins/{id}")
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(this.muffinRepository.findOne(id), HttpStatus.OK);
    }

    @PostMapping("/muffins")
    public ResponseEntity<Muffin> create(@RequestBody Muffin muffin) {
        return new ResponseEntity<>(this.muffinRepository.save(muffin), HttpStatus.CREATED);
    }

    @PutMapping("/muffins/{id}")
    public ResponseEntity<Muffin> update(@PathVariable Long id, @RequestBody Muffin muffin) {
        Muffin foundMuffin = muffinRepository.findOne(id);
        foundMuffin.setFlavor(muffin.getFlavor());

        return new ResponseEntity<>(this.muffinRepository.save(foundMuffin), HttpStatus.OK);
    }

    @DeleteMapping("/muffins/id")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        this.muffinRepository.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
