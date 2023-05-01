package ca.BaigiamasisBE.repositories;

import ca.BaigiamasisBE.entities.Helmet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelmetRepository.class)
public class repositoriesTest {

    @Mock
    HelmetRepository helmetRepository;
    @MockBean
    Helmet helmet;

//    @Test
//    void findAll_shouldReturnAll() {
//        Set<Helmet> newSet = Set.of(
//                new Helmet("-", "-", "-", "-", "-", "-", "-", 20),
//                new Helmet("-", "-", "-", "-", "-", "-", "-", 80),
//                new Helmet("-", "-", "-", "-", "-", "-", "-", 30),
//                new Helmet("-", "-", "-", "-", "-", "-", "-", 50)
//        );
//        helmetRepository.saveAll(newSet);
//
//        assertEquals(helmetRepository.findAll(),newSet);
//
//    }
}
