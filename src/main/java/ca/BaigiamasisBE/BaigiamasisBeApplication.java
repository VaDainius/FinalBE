package ca.BaigiamasisBE;

import ca.BaigiamasisBE.entities.Helmet;
import ca.BaigiamasisBE.entities.User;
import ca.BaigiamasisBE.repositories.HelmetRepository;
import ca.BaigiamasisBE.repositories.ShoppingCartRepository;
import ca.BaigiamasisBE.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class BaigiamasisBeApplication implements CommandLineRunner {
	private final HelmetRepository helmetRepository;
	private final ShoppingCartRepository cartRepository;
	private final UserRepository userRepository;
	public BaigiamasisBeApplication(HelmetRepository helmetRepository, ShoppingCartRepository cartRepository, UserRepository userRepository) {
		this.helmetRepository = helmetRepository;
		this.cartRepository = cartRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BaigiamasisBeApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		if(helmetRepository.findAll().stream().toList().equals("")){
			Set<Helmet> helmets = Set.of(
					new Helmet("motorcycle", "Shoei", "fx50", "S", "used","black","used, but mint condition",50),
					new Helmet("motorcycle", "AGV", "sp1", "M", "used","mixed","decent condition",70),
					new Helmet("bicycle", "Crivit", "-", "XL", "new","green","bought, never used",19),
					new Helmet("motorcycle", "Ilispan", "ultraMax-5000s", "XXL", "used","white","few minor scratches",20),
					new Helmet("racing", "Sparco", "-", "S", "used","white, red","brand new",400),
					new Helmet("bicycle", "-", "-", "L", "used","mixed","poor",5)
			);
			helmetRepository.saveAll(helmets);
		}

		if (userRepository.findAll().stream().toList().equals("")) {
			Set<User> users = Set.of(
					new User("admin", "admin","ADMIN"),
					new User("user", "user", "USER"),
					new User("read", "reader","READER")
			);
			userRepository.saveAll(users);
		}
	}
}
