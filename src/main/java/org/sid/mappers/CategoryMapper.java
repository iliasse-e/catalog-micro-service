package org.sid.mappers;

import org.mapstruct.Mapper;
import org.sid.dto.CategoryDTO;
import org.sid.entities.category.Category;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CategoryMapper {
	CategoryDTO categoryToProductResponseDTO(Category category);
	Category categoryRequestDTOToCategory(CategoryDTO categoryRequestDTO);
}
