package org.sid.dao;

import java.util.List;

import org.sid.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>, CrudRepository<Product, Long> {
	
	public List<Product> findByDesignation(String designation);
}
