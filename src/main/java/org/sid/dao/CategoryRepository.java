package org.sid.dao;

import org.sid.entities.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category getById(Long id);
	Category findByName(String name);
}