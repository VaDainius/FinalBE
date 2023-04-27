package ca.BaigiamasisBE.repositories;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

//    ShoppingCart save(Helmet helmet);
}
