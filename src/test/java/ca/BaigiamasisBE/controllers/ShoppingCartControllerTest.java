package ca.BaigiamasisBE.controllers;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.entities.ShoppingCart;
import ca.BaigiamasisBE.repositories.HelmetRepository;
import ca.BaigiamasisBE.repositories.ShoppingCartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class ShoppingCartControllerTest {

    @MockBean
    private ShoppingCartController shoppingCartController;

    @MockBean
    private ShoppingCart shoppingCart;

    @MockBean
    private Helmet helmet;

    @MockBean
    private HelmetRepository helmetRepository;

    @MockBean
    private ShoppingCartRepository shoppingCartRepository;

    @Test
    void whenShowAll_ShouldReturnAllHelmetsInShoppingCart() {
        List<Helmet> helmetList = new ArrayList<>();
                Helmet helmet1 = new Helmet("Ski", "Sprint", "Competition",
                "S", "Used", "beige", "As new", 60);
                Helmet helmet2 = new Helmet("Skater", "Tony's", "LikeAhaWk",
                "XXL", "Used", "metallic pink", "Poor poor condition", 800
                );
                helmetList.add(helmet1);
                helmetList.add(helmet2);
        helmetRepository.saveAll(helmetList);
        ShoppingCart newCart =
                new ShoppingCart(helmet1);
        System.out.println(newCart + "--------------------------------");
        shoppingCartRepository.save(newCart);
        var result = shoppingCartController.showAll();
        System.out.println(result  + "-----------------------------------");
        System.out.println(shoppingCartRepository.findAll()  + "-----------------------------------");
        assertEquals(shoppingCartRepository.findAll(), result);

    }

//    @Test
//    void whenDeleteHelmetByManufacturerAndModel_ShouldDeleteFromCart() {
//        Helmet helmet = new Helmet(
//                "Ski", "Sprint", "Competition",
//                "S", "Used", "beige", "As new", 60
//        );
//        helmetRepository.save(helmet);
//        ShoppingCart cart = new ShoppingCart(helmet);
//        shoppingCartRepository.save(cart);
//        String manufacturer = helmet.getManufacturer();
//        String model = helmet.getModel();
//        shoppingCartController.deleteItem(manufacturer,model);
//        assertTrue(shoppingCartRepository.findByHelmet(helmet).isEmpty());
//    }
}
