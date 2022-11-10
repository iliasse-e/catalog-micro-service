package org.sid;

import org.sid.dao.CategoryRepository;
import org.sid.dto.CategoryDTO;
import org.sid.dto.ProductDTO;
import org.sid.security.entities.AppRole;
import org.sid.security.entities.AppUser;
import org.sid.security.service.AccountService;
import org.sid.service.CategoryService;
import org.sid.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class MyProductAppApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(MyProductAppApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner start(ProductService productService, CategoryService categoryService, AccountService accountService) {
		return args -> {
			categoryService.save(new CategoryDTO("CARPET"));
			categoryService.save(new CategoryDTO("BED"));
			categoryService.save(new CategoryDTO("CUP"));
			categoryService.save(new CategoryDTO("BOWL"));
			categoryService.save(new CategoryDTO("CHAIR"));
			categoryService.save(new CategoryDTO("LIGHT"));
			categoryService.save(new CategoryDTO("POT"));
			categoryService.save(new CategoryDTO("TABLE"));
			categoryService.save(new CategoryDTO("PLATE"));


			productService.save(new ProductDTO("Boukhara", 25, 25, "35x30", new CategoryDTO("CARPET")));
			productService.save(new ProductDTO("Turkish Ibrik", 25, 25, "35x30", new CategoryDTO("POT")));

			accountService.addNewRole(new AppRole(null, "USER"));
			accountService.addNewRole(new AppRole(null, "ADMIN"));
			accountService.addNewUser(new AppUser(null, "user_1", "0000", new ArrayList<>()));

			accountService.addNewUser(new AppUser(null, "admin_1", "0000", new ArrayList<>()));
			accountService.addRoleToUser("user_1", "USER");
			accountService.addRoleToUser("admin_1", "USER");
			accountService.addRoleToUser("admin_1", "ADMIN");

		};
	}

}
