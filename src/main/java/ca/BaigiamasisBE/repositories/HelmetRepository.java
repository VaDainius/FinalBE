package ca.BaigiamasisBE.repositories;

import ca.BaigiamasisBE.entities.Helmet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HelmetRepository extends JpaRepository<Helmet, Integer> {

    Helmet findById(int id);

    List<Helmet> findByPrice(int price);

    List<Helmet> findByType(String type);

    List<Helmet> findBySize(String size);

    List<Helmet> findByColor(String color);
}
