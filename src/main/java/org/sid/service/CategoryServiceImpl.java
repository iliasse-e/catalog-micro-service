package org.sid.service;

import org.sid.dao.CategoryRepository;
import org.sid.dto.CategoryDTO;
import org.sid.entities.category.Category;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public CategoryDTO save(CategoryDTO categoryRequestDTO) {
		// TODO Auto-generated method stub
		Category category = categoryRequestDTOToCategory(categoryRequestDTO);
		Category savedCategory = categoryRepository.save(category);
		CategoryDTO categoryResponseDTO = categoryToProductResponseDTO(savedCategory);
		return categoryResponseDTO;
	}

	@Override
	public Category getCategory(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.findByName(name);
	}

	@Override
	public CategoryDTO update(CategoryDTO categoryRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<CategoryDTO> listProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	private CategoryDTO categoryToProductResponseDTO(Category category) {
		// TODO Auto-generated method stub
		String categoryName = category.getName();
		return new CategoryDTO(categoryName);
	}


	private Category categoryRequestDTOToCategory(CategoryDTO categoryRequestDTO) {
		// TODO Auto-generated method stub
		Category category = new Category();
		category.setName(categoryRequestDTO.getName());
		return category;
	}
}
