package ca.BaigiamasisBE.repositories;

import ca.BaigiamasisBE.entities.Helmet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HelmetRepository extends JpaRepository<Helmet, Integer> {

    Helmet findById(int id);

    Helmet findByPrice(int price);

    Helmet findByType(String type);

    Helmet findBySize(int size);

    Helmet findByColor(String color);
}
