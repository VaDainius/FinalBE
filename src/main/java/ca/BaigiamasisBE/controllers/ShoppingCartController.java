package ca.BaigiamasisBE.controllers;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.entities.ShoppingCart;
import ca.BaigiamasisBE.repositories.HelmetRepository;
import ca.BaigiamasisBE.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingCartController {
    private final HelmetRepository helmetRepository;

    private final ShoppingCartRepository cartRepository;

    public ShoppingCartController(@Autowired HelmetRepository helmetRepository,
                                  @Autowired ShoppingCartRepository cartRepository) {
        this.helmetRepository = helmetRepository;
        this.cartRepository = cartRepository;
    }

    @GetMapping("/cart")
    public ResponseEntity<List<ShoppingCart>> showAll(){
        return new ResponseEntity<>(new ArrayList<>(cartRepository.findAll()),
                HttpStatus.OK
        );
    }

//    @DeleteMapping("/cart/delete/{id}")
//    public void deleteItem(@PathVariable int id) {
//        cartRepository.deleteById(id);
//    }
//    @DeleteMapping("/cart/delete/{manufacturer}/{model}")
//    public void deleteItem(@PathVariable String manufacturer, @PathVariable String model) {
//        Helmet helmet = helmetRepository.findByManufacturerAndModel(manufacturer, model).stream().findAny()
//                .orElseThrow(() -> new RuntimeException("Helmet not found"));
//
//        ShoppingCart cart = cartRepository.findByHelmet(helmet).stream().findAny()
//                .orElseThrow(() -> new RuntimeException("Item not found in cart"));
//
//        cartRepository.delete(cart);
//    }
}
