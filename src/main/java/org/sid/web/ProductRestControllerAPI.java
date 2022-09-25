package org.sid.web;

import java.util.List;

import org.sid.dao.CategoryRepository;
import org.sid.dto.CategoryDTO;
import org.sid.dto.ProductDTO;
import org.sid.entities.category.Category;
import org.sid.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductRestControllerAPI {
	
	@Autowired
	private ProductService productService;
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public List<ProductDTO> productList() {
		return productService.listProducts();
	}
	
	@GetMapping("/{id}")
	public ProductDTO getOne(@PathVariable Long id) {
		return productService.getProduct(id);
	}
	
	@PostMapping
	public ProductDTO save(@RequestBody ProductCreationInput p) {
		//check if category exists in data base
		return productService.save(p.ToProductRequestDTO());
	}
	
	@PutMapping("/{id}")
	public ProductDTO update(@RequestBody ProductDTO p,@PathVariable Long id) {
		return productService.update(p);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		productService.delete(id);
	}
}
