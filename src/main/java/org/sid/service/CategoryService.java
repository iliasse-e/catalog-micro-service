package org.sid.service;

import java.util.List;

import org.sid.dto.CategoryDTO;
import org.sid.entities.category.Category;

public interface CategoryService {
	CategoryDTO save(CategoryDTO categoryDTO);
	Category getCategory(String name);
	CategoryDTO update(CategoryDTO categoryRequestDTO);
	List<CategoryDTO> listProducts();
}
