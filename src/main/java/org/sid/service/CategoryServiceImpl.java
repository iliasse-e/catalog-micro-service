package org.sid.service;

import java.util.List;

import javax.transaction.Transactional;

import org.sid.dao.CategoryRepository;
import org.sid.dto.CategoryDTO;
import org.sid.entities.category.Category;
import org.sid.mappers.CategoryMapperImpl;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository;
	private CategoryMapperImpl categoryMapperImpl;
	
	public CategoryServiceImpl(CategoryMapperImpl categoryMapperImpl, CategoryRepository categoryRepository) {
		this.categoryMapperImpl = categoryMapperImpl;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public CategoryDTO save(CategoryDTO categoryRequestDTO) {
		// TODO Auto-generated method stub
		Category category = categoryMapperImpl.categoryRequestDTOToCategory(categoryRequestDTO);
		Category savedCategory = categoryRepository.save(category);
		CategoryDTO categoryResponseDTO = categoryMapperImpl.categoryToProductResponseDTO(savedCategory);
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

}
