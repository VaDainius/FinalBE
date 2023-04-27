package ca.BaigiamasisBE.controllers;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.entities.User;
import ca.BaigiamasisBE.repositories.HelmetRepository;
import ca.BaigiamasisBE.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.NoSuchElementException;
import java.util.Set;

@Controller
public class HomeController {
    private final UserRepository userRepository;

    private final HelmetRepository helmetRepository;

    public HomeController(@Autowired UserRepository userRepository, @Autowired HelmetRepository helmetRepository) {
        this.userRepository = userRepository;
        this.helmetRepository = helmetRepository;
    }

//    @GetMapping("/home")
//    public String home(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUser = authentication.getName();
//
//        User user = userRepository.findByUsername(currentUser).orElseThrow(
//                () -> new NoSuchElementException("No such user with the given Username: " + currentUser)
//        );
//        Set<Helmet> helmets = user.getHelmets();
//        model.addAttribute("helmets", helmets);
//
//        return "home";
//    }
}
