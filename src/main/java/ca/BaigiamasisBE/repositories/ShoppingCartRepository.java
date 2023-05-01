package ca.BaigiamasisBE.repositories;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    ShoppingCart save(Helmet helmet);

    List<ShoppingCart> addToCart(ShoppingCart cart);
}
