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
//		Set<Helmet> helmets = Set.of(
//				new Helmet("motorcycle", "Shoei", "fx50", 5, "used","black","used, but mint condition",25),
//				new Helmet("motorcycle", "AGV", "5x5x", 10, "new","gray","bought, but never used",50)
//		);
//		helmetRepository.saveAll(helmets);

//		Set<User> users = Set.of(
//				new User("user", "pass", "ADMIN"),
//				new User("use", "pssa", "USER")
//		);
//
//		userRepository.saveAll(users);
	}
}
