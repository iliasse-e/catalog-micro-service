//package org.sid.mappers;
//
//import org.sid.dto.CategoryDTO;
//import org.sid.entities.category.Category;
//import org.springframework.stereotype.Component;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Data @AllArgsConstructor
//@Component
//public class CategoryMapperImpl implements CategoryMapper {
//
//	@Override
//	public CategoryDTO categoryToProductResponseDTO(Category category) {
//		// TODO Auto-generated method stub
//		String categoryName = category.getName();
//		return new CategoryDTO(categoryName);
//	}
//
//	@Override
//	public Category categoryRequestDTOToCategory(CategoryDTO categoryRequestDTO) {
//		// TODO Auto-generated method stub
//		Category category = new Category();
//		category.setName(categoryRequestDTO.getName());
//		return category;
//	}
//
//}
