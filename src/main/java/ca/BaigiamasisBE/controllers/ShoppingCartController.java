package ca.BaigiamasisBE.controllers;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.entities.ShoppingCart;
import ca.BaigiamasisBE.repositories.HelmetRepository;
import ca.BaigiamasisBE.repositories.ShoppingCartRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String shoppingCart (Model model, BindingResult errors) {
        if (errors.hasErrors()) {
            return "home";
        }
        model.addAttribute(cartRepository.findAll());
        return "cart";
    }
    @DeleteMapping("/cart/delete/{id}")
    public String deleteItem(@PathVariable long id) {
        cartRepository.deleteById(id);
        return "home";
    }

//    @PostMapping("/cart/add/{id}")
//    public String addToCart(@Valid Helmet helmet, BindingResult errors) {
//        if (errors.hasErrors()) {
//            return "/home";
//        }
//        cartRepository.save(helmet);
//        return "/home";
//    }
}
