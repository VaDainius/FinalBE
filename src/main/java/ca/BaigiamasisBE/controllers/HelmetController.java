package ca.BaigiamasisBE.controllers;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.entities.Helmets;
import ca.BaigiamasisBE.repositories.HelmetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HelmetController {

    private final HelmetRepository helmetRepository;


    public HelmetController(@Autowired HelmetRepository helmetRepository) {
        this.helmetRepository = helmetRepository;
    }

    @GetMapping("/helmets")
    public ResponseEntity<Helmets> helmets() {
        return new ResponseEntity<>(
                new Helmets(helmetRepository.findAll()),
                HttpStatus.OK
        );
    }
    @GetMapping("/helmet/byId/{id}")
    public ResponseEntity<Helmet> helmetById(@RequestBody int id) {
        return new ResponseEntity<>(helmetRepository.findById(id), HttpStatus.OK
        );
    }
    @GetMapping("/helmet/{price}")
    public ResponseEntity<Helmet> helmetByPrice(@PathVariable int price) {
        return new ResponseEntity<>(helmetRepository.findByPrice(price),
                HttpStatus.OK
        );
    }
    @GetMapping("/helmet/{type}")
    public ResponseEntity<Helmet> helmetByType (@PathVariable String type) {
        return new ResponseEntity<>(helmetRepository.findByType(type),
                HttpStatus.OK
        );
    }
    @GetMapping("/helmet/{size}")
    public ResponseEntity<Helmet> helmetBySize (@PathVariable int size) {
        return new ResponseEntity<>(helmetRepository.findBySize(size),
                HttpStatus.OK
        );
    }
    @GetMapping("/helmet/{color}")
    public ResponseEntity<Helmet> helmetByColor (@PathVariable String color) {
        return new ResponseEntity<>(helmetRepository.findByColor(color),
                HttpStatus.OK
        );
    }

}
