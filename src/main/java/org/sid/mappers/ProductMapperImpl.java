package org.sid.mappers;

import org.sid.dao.CategoryRepository;
import org.sid.dto.CategoryDTO;
import org.sid.dto.ProductDTO;
import org.sid.entities.category.Category;
import org.sid.entities.product.Product;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
@Component
public class ProductMapperImpl implements ProductMapper {
	
	private final CategoryRepository categoryRepository;
	
	@Override
	public ProductDTO productToProductResponseDTO(Product product) {
		// TODO Auto-generated method stub
		String designation = product.getDesignation();
		int price = product.getPrice();
		int quantity = product.getQuantity();
		String dimensions = product.getDimensions();
		String categoryName = product.getCategory().toString();
		return new ProductDTO(designation, price, quantity, dimensions, new CategoryDTO(categoryName));
	}

	@Override
	public Product productRequestDTOToProduct(ProductDTO productRequestDTO) {
		// TODO Auto-generated method stub
		String designation = productRequestDTO.getDesignation();
		String name = productRequestDTO.getCategory().getName();
		int price = productRequestDTO.getPrice();
		int quantity = productRequestDTO.getQuantity();
		String dimensions = productRequestDTO.getDimensions();
		Category category = categoryRepository.findByName(name);
		return new Product(null, designation, price, quantity, dimensions, category);
	}

}
