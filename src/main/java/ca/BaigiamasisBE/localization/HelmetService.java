package ca.BaigiamasisBE.localization;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.repositories.HelmetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class HelmetService {

    private final HelmetRepository helmetRepository;

    public HelmetService(@Autowired HelmetRepository helmetRepository) {
        this.helmetRepository = helmetRepository;
    }

    public Class<? extends Helmet> getPaged(@PathVariable int id) {

        return helmetRepository.findById(id).getClass();
    }
}
