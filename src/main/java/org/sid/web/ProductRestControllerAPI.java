package org.sid.web;

import java.util.List;

import org.sid.dao.CategoryRepository;
import org.sid.dto.CategoryDTO;
import org.sid.dto.ProductDTO;
import org.sid.entities.category.Category;
import org.sid.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/products")
public class ProductRestControllerAPI {
	
	private final ProductService productService;

	public ProductRestControllerAPI(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<ProductDTO> productList() {
		return productService.listProducts();
	}
	
	@GetMapping("/{designation}")
	public ProductDTO getOne(@PathVariable String designation) {
		return productService.getProduct(designation);
	}
	
	@PostMapping
	public ProductDTO save(@RequestBody ProductDTO p) {
		//check if category exists in data base
		return productService.save(p);
	}
	
	@PutMapping("/{designation}")
	public ProductDTO update(@RequestBody ProductDTO p,@PathVariable String designation) {
		return productService.update(p, designation);
	}
	
	@DeleteMapping("/{designation}")
	public void delete(@PathVariable String designation) {
		productService.delete(designation);
	}
}
