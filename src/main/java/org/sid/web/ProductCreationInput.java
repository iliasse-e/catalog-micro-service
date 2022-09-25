package org.sid.web;

import org.sid.dto.CategoryDTO;
import org.sid.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductCreationInput {
	private String designation;
	private int price;
	private int quantity;
	private String dimensions;
	private String category;
	
	public CategoryDTO getCategoryDTO() {
		return new CategoryDTO(category);
	}
	
	public ProductDTO ToProductRequestDTO() {
		// TODO Auto-generated method stub
		CategoryDTO categoryDTO = new CategoryDTO(category);
		return new ProductDTO(designation, price, quantity, dimensions, categoryDTO);
	}
}
