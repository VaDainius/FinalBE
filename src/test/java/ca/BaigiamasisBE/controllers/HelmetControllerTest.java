package ca.BaigiamasisBE.controllers;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.entities.Helmets;
import ca.BaigiamasisBE.repositories.HelmetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class HelmetControllerTest {

    @MockBean
    private HelmetController helmetController;
    @MockBean
    private HelmetRepository helmetRepository;

    public HelmetControllerTest(@Autowired HelmetRepository helmetRepository,
                                @Autowired HelmetController helmetController
    ) {
        this.helmetRepository = helmetRepository;
        this.helmetController = helmetController;
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        helmetController = new HelmetController(helmetRepository);
    }

    @Test
    public void whenAsked_returnsAllHelmets() {
        List<Helmet> helmetList = new ArrayList<>();
        helmetList.add(new Helmet(
                "motorcycle", "Bell",
                "az2", "L", "new",
                "Black", "newer used",
                90
        ));
        helmetList.add(new Helmet(
                "motorcycle", "Scorpion",
                "exo-520", "S", "new",
                "white", "Used for 10 minutes",
                70
        ));

        when(helmetRepository.findAll()).thenReturn(helmetList);
        ResponseEntity<Helmets> responseEntity = helmetController.helmets();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(helmetList, responseEntity.getBody().getHelmets());
    }

    @Test
    public void whenAskedForHelmets_returnsByPrice() throws Exception {
        int price = 70;
        List<Helmet> helmetList = new ArrayList<>();
        Helmet newHelmet = new Helmet(
                "motorcycle","Scorpion",
                "exo-520", "S", "new",
                "white", "Used for 10 minutes",
                70
        );

        helmetList.add(newHelmet);
        when(helmetRepository.findByPrice(price)).thenReturn(helmetList);
        ResponseEntity<List<Helmet>> responseEntity = helmetController.helmetByPrice(price);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(helmetList, responseEntity.getBody());
    }

    @Test
    public void whenAskedForHelmets_returnsByType() {
        String type = "motorcycle";
        List<Helmet> helmetList = new ArrayList<>();
        helmetList.add(new Helmet(
                "motorcycle","Scorpion",
                "exo-520", "S", "new",
                "white", "Used for 10 minutes",
                70
        ));

        when(helmetRepository.findByType(type)).thenReturn(helmetList);
        ResponseEntity<List<Helmet>> responseEntity = helmetController.helmetByType(type.trim().toLowerCase());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(helmetList, responseEntity.getBody());
    }

    @Test
    public void whenAskedForHelmets_returnsBySize() {
        String size = "S";
        List<Helmet> helmetList = new ArrayList<>();
        helmetList.add(new Helmet(
                "motorcycle","Scorpion",
                "exo-520", "S", "new",
                "white", "Used for 10 minutes",
                70
        ));

        when(helmetRepository.findBySize(size)).thenReturn(helmetList);
        ResponseEntity<List<Helmet>> responseEntity = helmetController.helmetBySize(size);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(helmetList, responseEntity.getBody());
    }

    @Test
    public void whenAskedForHelmets_returnsByColor() {
        String color = "Black";
        List<Helmet> helmetList = new ArrayList<>();
        helmetList.add(new Helmet(
                "motorcycle","Bell",
                "az2", "L", "new",
                "Black", "newer used",
                90
        ));

        when(helmetRepository.findByColor(color)).thenReturn(helmetList);
        ResponseEntity<List<Helmet>> responseEntity = helmetController.helmetByColor(color);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(helmetList, responseEntity.getBody());
    }
}
