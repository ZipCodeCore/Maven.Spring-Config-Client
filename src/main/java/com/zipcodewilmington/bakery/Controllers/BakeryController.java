package com.zipcodewilmington.bakery.Controllers;

import com.zipcodewilmington.bakery.Models.Bakery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BakeryController {
    Bakery bakery;

    BakeryController(Bakery bakery) {
       this.bakery = bakery;
    }

    @GetMapping("/bakery")
    public ResponseEntity<Bakery> show() {
        return new ResponseEntity<>(this.bakery, HttpStatus.OK);
    }
}
