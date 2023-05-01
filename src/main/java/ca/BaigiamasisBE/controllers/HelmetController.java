package ca.BaigiamasisBE.controllers;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.entities.Helmets;
import ca.BaigiamasisBE.repositories.HelmetRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping("/helmet/price/{price}")
    public ResponseEntity<List<Helmet>> helmetByPrice(@PathVariable int price) {
        var helmetPriceList =helmetRepository.findByPrice(price);
        var helmetPriceStream = helmetPriceList
                .stream()
                .filter(h -> h.getPrice() == price)
                .collect(Collectors.toList());
        return new ResponseEntity<>(helmetPriceStream,
                HttpStatus.OK
        );
    }
    @GetMapping("/helmet/type/{type}")
    public ResponseEntity<List<Helmet>> helmetByType (@PathVariable String type) {
        List<Helmet> helmet = helmetRepository.findByType(type);
        var helmetTypeList = helmet
                .stream().
                filter(helmet1 -> helmet1.getType().toLowerCase().trim().equals(type.toLowerCase().trim()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(helmetTypeList,
                HttpStatus.OK
        );
    }
    @GetMapping("/helmet/size/{size}")
    public ResponseEntity<List<Helmet>> helmetBySize (@PathVariable String  size) {
        var helmetSizeList = helmetRepository.findBySize(size);
        var helmetSizeStream = helmetSizeList
                .stream()
                .filter(s -> s.getSize().toUpperCase().trim().equals(size.toUpperCase().trim()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(helmetSizeStream,
                HttpStatus.OK
        );
    }
    @GetMapping("/helmet/color/{color}")
    public ResponseEntity<List<Helmet>> helmetByColor (@PathVariable String color) {
        var helmetColorList = helmetRepository.findByColor(color);
        var helmetColorListStream = helmetColorList
                .stream().
                filter(c -> c.getColor().trim().toLowerCase().contains(color.toLowerCase().trim()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(helmetColorListStream,
                HttpStatus.OK
        );
    }
    @PostMapping("/helmet/new")
    public String newHelmet(@Valid Helmet helmet, BindingResult errors, HttpSession session) {
        if (errors.hasErrors()) {
            return "/helmet/new";
        }
        helmetRepository.save(helmet);
        return "redirect:/";
    }

    @DeleteMapping("/helmets")
    public String deleteAll() {
        helmetRepository.deleteAll();
        return "redirect:/";
    }
}
