package ca.BaigiamasisBE.controllers;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.entities.ShoppingCart;
import ca.BaigiamasisBE.repositories.HelmetRepository;
import ca.BaigiamasisBE.repositories.ShoppingCartRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

//    @PostMapping("/helmets")
//    public ResponseEntity<ShoppingCart> addFromShopToCart(Helmet helmet) {
//        var cartList = cartRepository.findAll();
//        cartList.stream()
//                .filter(i -> i.getHelmets().removeIf(helmet1 -> h))
//    }
    @DeleteMapping("/cart/delete/{id}")
    public void deleteItem(@PathVariable int id) {
        cartRepository.deleteById(id);
    }

}
