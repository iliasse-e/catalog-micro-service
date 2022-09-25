package org.sid.mappers;

import org.sid.dto.CategoryDTO;
import org.sid.entities.category.Category;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
@Component
public class CategoryMapperImpl implements CategoryMapper {

	@Override
	public CategoryDTO categoryToProductResponseDTO(Category category) {
		// TODO Auto-generated method stub
		String categoryType = category.getName();
		return new CategoryDTO(categoryType);
	}

	@Override
	public Category categoryRequestDTOToCategory(CategoryDTO categoryRequestDTO) {
		// TODO Auto-generated method stub
		String categoryType = categoryRequestDTO.getName();
		return new Category(null, categoryType);
	}

}
