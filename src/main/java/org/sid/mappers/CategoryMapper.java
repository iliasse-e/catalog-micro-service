package org.sid.mappers;

import org.mapstruct.Mapper;
import org.sid.dto.CategoryDTO;
import org.sid.entities.category.Category;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	CategoryDTO categoryToProductDTO(Category category);
	Category categoryDTOToCategory(CategoryDTO categoryDTO);
}
