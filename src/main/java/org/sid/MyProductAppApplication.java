package org.sid;

import org.sid.dao.CategoryRepository;
import org.sid.dto.CategoryDTO;
import org.sid.dto.ProductDTO;
import org.sid.service.CategoryService;
import org.sid.service.ProductService;
import org.sid.web.ProductCreationInput;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyProductAppApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(MyProductAppApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductService productService, CategoryService categoryService, CategoryRepository categoryRepository) {
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
			
			
			System.out.println(
					categoryRepository.findByName("CARPET")
					);
			
			ProductCreationInput p = new ProductCreationInput("TEST 5", 20, 20, "3x10", "CHAIR");
			
			System.out.println(
					productService.save(p.ToProductRequestDTO())
					);

			productService.save(new ProductDTO("Boukhara", 25, 25, "35x30", new CategoryDTO("CARPET")));
			productService.save(new ProductDTO("Turkish Ibrik", 25, 25, "35x30", new CategoryDTO("POT")));
		};
	}

}
