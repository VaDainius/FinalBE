package ca.BaigiamasisBE.repositories;

import ca.BaigiamasisBE.entities.Helmet;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
public interface HelmetRepository extends JpaRepository<Helmet, Integer> {

    Helmet findById(int id);

    List<Helmet> findByPrice(int price);

    List<Helmet> findByType(String type);

    List<Helmet> findBySize(String size);

    List<Helmet> findByColor(String color);

    List<Helmet> findAll();

    List<Helmet> findByManufacturerAndModel(String manufacturer, String model);
}
