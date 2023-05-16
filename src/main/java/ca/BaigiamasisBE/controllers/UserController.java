package ca.BaigiamasisBE.controllers;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.entities.User;
import ca.BaigiamasisBE.repositories.HelmetRepository;
import ca.BaigiamasisBE.repositories.UserRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private UserRepository userRepository;

    private HelmetRepository helmetRepository;

    public UserController(@Autowired UserRepository userRepository,
                          @Autowired HelmetRepository helmetRepository
    ) {
        this.userRepository = userRepository;
        this.helmetRepository = helmetRepository;
    }


    @GetMapping("/user/id/{id}")
    public ResponseEntity<Optional<User>> getUsers(@PathVariable int id) {
        var byId = userRepository.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> allUsers() {
        var userStream = userRepository.findAll().stream().collect(Collectors.toList());
        return new ResponseEntity<>(userStream,HttpStatus.OK);
    }
    @GetMapping("/user/username/{username}")
    public ResponseEntity<List<User>> userByUsername (@PathVariable String username) {
        var usernameList = userRepository.findByUsername(username);
        var usernameStream = usernameList
                .stream()
                .filter(user -> user.getUsername()
                        .trim().toLowerCase()
                        .equals(username.trim().toLowerCase()))
                .collect(Collectors.toList());

                return new ResponseEntity<>(usernameStream, HttpStatus.OK);
    }

    @PostMapping("/user/new")
    public ResponseEntity<User> newUser(@RequestBody @Valid User user, BindingResult errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/user/delete/username/{username}")
    public ResponseEntity<Helmet> deleteUserByUsername(@PathVariable String username) {
        var listToDel = userRepository.findByUsername(username);
        listToDel
                .stream()
                .filter(d -> d.getUsername().toLowerCase()
                        .trim().equals(username.trim().toLowerCase()))
                .forEach(userRepository::delete);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
