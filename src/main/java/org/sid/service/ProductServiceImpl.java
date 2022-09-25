package org.sid.service;

import org.sid.dao.CategoryRepository;
import org.sid.dao.ProductRepository;
import org.sid.dto.CategoryDTO;
import org.sid.dto.ProductDTO;
import org.sid.entities.category.Category;
import org.sid.entities.product.Product;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public ProductDTO save(ProductDTO productRequestDTO) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findByName(productRequestDTO.getCategory().getName());

		Product product = productRequestDTOToProduct(productRequestDTO,category);
		Product savedProduct = productRepository.save(product);
		ProductDTO productResponseDTO = productToProductResponseDTO(savedProduct);
		
		return productResponseDTO;
	}

	@Override
	public ProductDTO getProduct(Long productId) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(productId).get();
		return productToProductResponseDTO(product);
	}

	@Override
	public ProductDTO update(ProductDTO productRequestDTO) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findByName(productRequestDTO.getCategory().getName());
		Product product = productRequestDTOToProduct(productRequestDTO,category);
		Product updatedProduct = productRepository.save(product);
		return productToProductResponseDTO(updatedProduct);
	}

	@Override
	public List<ProductDTO> listProducts() {
		// TODO Auto-generated method stub
		List<Product> listProducts = productRepository.findAll();
		List<ProductDTO> listProductResponseDTOs = listProducts
				.stream()
				.map(p -> productToProductResponseDTO(p))
				.collect(Collectors.toList());
		return listProductResponseDTOs;
	}

	@Override
	public void delete(Long productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
		
	}

	private Product productRequestDTOToProduct(ProductDTO productRequestDTO,Category category) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setDesignation(productRequestDTO.getDesignation());
		product.setPrice(productRequestDTO.getPrice());
		product.setQuantity(productRequestDTO.getQuantity());
		product.setDimensions(productRequestDTO.getDimensions());
		product.setCategory(category);
		return product;
	}

	public ProductDTO productToProductResponseDTO(Product product) {
		// TODO Auto-generated method stub
		String designation = product.getDesignation();
		int price = product.getPrice();
		int quantity = product.getQuantity();
		String dimensions = product.getDimensions();
		String categoryName = product.getCategory().getName();
		return new ProductDTO(designation, price, quantity, dimensions, new CategoryDTO(categoryName));
	}
}
