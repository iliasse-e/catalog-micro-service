package org.sid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductDTO {
	private String designation;
	private int price;
	private int quantity;
	private String dimensions;
	private CategoryDTO category;
}
