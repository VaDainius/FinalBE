package ca.BaigiamasisBE.repositories;

import ca.BaigiamasisBE.entities.Helmet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class HelmetRepositoryTest {

    @MockBean
    private HelmetRepository helmetRepository;
    @MockBean
    private Helmet helmet;


    public HelmetRepositoryTest(@Autowired HelmetRepository helmetRepository, @Autowired Helmet helmet) {
        this.helmetRepository = helmetRepository;
        this.helmet = helmet;
    }
    @BeforeEach
    public void setUp(){
        List<Helmet> newList = List.of(
                new Helmet(
                        "war", "Crivit", "helmet4life",
                        "XL", "used", "gray", "Fits well", 20
                ),
                new Helmet(
                        "bicycle", "Lumpatau", "SpeedX100",
                        "L", "used", "red", "all good", 80
                )
        );
        when(helmetRepository.findAll()).thenReturn(newList);
    }
    @Test
    void findAll_shouldReturnAll() {
        List<Helmet> newList = List.of(
                new Helmet(
                        "war", "Crivit", "helmet4life",
                        "XL", "used", "gray", "Fits well", 20
                ),
                new Helmet(
                        "bicycle", "Lumpatau", "SpeedX100",
                        "L", "used", "red", "all good", 80
                )
        );
        helmetRepository.saveAll(newList);
        assertEquals(newList, helmetRepository.findAll());

    }
}
