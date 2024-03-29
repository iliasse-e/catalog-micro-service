package org.sid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductDTO {
	private String designation;
	private int price;
	private int quantity;
	private String dimensions;
	private CategoryDTO category;
}
