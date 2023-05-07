package ca.BaigiamasisBE.controllers;

import ca.BaigiamasisBE.entities.User;
import ca.BaigiamasisBE.repositories.HelmetRepository;
import ca.BaigiamasisBE.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class UserControllerTest {

    @MockBean
    private User user;
    @MockBean
    private UserController userController;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private HelmetRepository helmetRepository;

    public UserControllerTest(@Autowired User user,
                              @Autowired UserController userController,
                              @Autowired UserRepository userRepository,
                              @Autowired HelmetRepository helmetRepository
    ) {
        this.user = user;
        this.userController = userController;
        this.userRepository = userRepository;
        this.helmetRepository = helmetRepository;
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userController = new UserController(userRepository, helmetRepository);
    }

    @Test
    void whenGetUsers_shouldReturnUser() {
        User user = new User("username", "password", "ADMIN");
        Optional<User> optionalUser = Optional.of(user);
        when(userRepository.findById(any(Integer.class))).thenReturn(optionalUser);

        Optional<User> result = userController.getUsers(1).getBody();

        assertEquals(optionalUser, result);
    }

    @Test
    void whenGetAllUsers_shouldReturnListOfUsers() {
        List<User> users = List.of(
                new User("Anthuan", "sapup", "USER"),
                new User("Intribidijus", "ilibit", "USER"),
                new User("Artumedija", "biTikZyyz", "USER")

        );
        when(userRepository.findAll()).thenReturn(users);
        userRepository.saveAll(users);
        userRepository.findAll();
        List<User> usersInRepo = userController.allUsers().getBody();

        assertEquals(users,usersInRepo);
    }

    @Test
    void whenNewUser_ShouldCreateNewUser() {
        User user1 = new User("Archibald", "meatpants", "ADMIN");
        when(userRepository.save(any(User.class))).thenReturn(user1);
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);

        String saveUser = userController.newUser(user1, bindingResult);

        assertEquals("Success", saveUser);
    }

    @Test
    void whenDeleteUserByUsername_ShouldDeleteUser() {
        List<User> userList = List.of(
                new User("Marcipan", "kuntapel", "USER"),
                new User("Ferdinando", "crocs", "USER")
        );
        when(userRepository.findByUsername(any(String.class))).thenReturn(userList);

        String delete = userController.deleteUserByUsername("Ferdinando");

        assertEquals("User deleted", delete);
    }


}
