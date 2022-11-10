package org.sid.service;

import org.sid.dao.CategoryRepository;
import org.sid.dao.ProductRepository;
import org.sid.dto.CategoryDTO;
import org.sid.dto.ProductDTO;
import org.sid.entities.category.Category;
import org.sid.entities.product.Product;
import org.sid.mappers.CategoryMapper;
import org.sid.mappers.ProductMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private ProductMapper productMapper;

	public ProductServiceImpl(
			ProductRepository productRepository,
			CategoryRepository categoryRepository,
			ProductMapper productMapper
	) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.productMapper = productMapper;
	}

	@Override
	public ProductDTO save(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		System.out.println(productDTO);

		Product newProduct = productMapper.productDTOToProduct(productDTO);
		System.out.println(newProduct);
		Product savedProduct = productRepository.save(newProduct);

		return productMapper.productToProductDTO(savedProduct);
	}

	@Override
	public ProductDTO getProduct(String designation) {
		// TODO Auto-generated method stub
		Product product = productRepository.findByDesignation(designation);
		return productMapper.productToProductDTO(product);
	}

	@Override
	public ProductDTO update(ProductDTO updatedProduct, String designation) {
		// get product from repo
		Product product = productRepository.findByDesignation(designation);
		// set new data
		product.setDesignation(updatedProduct.getDesignation());
		product.setPrice(updatedProduct.getPrice());
		product.setQuantity(updatedProduct.getQuantity());
		product.setDimensions(updatedProduct.getDimensions());
		return productMapper.productToProductDTO(product);
	}

	@Override
	public List<ProductDTO> listProducts() {
		// TODO Auto-generated method stub
		List<Product> listProducts = productRepository.findAll();
		List<ProductDTO> listProductResponseDTOs = listProducts
				.stream()
				.map(p -> productMapper.productToProductDTO(p))
				.collect(Collectors.toList());
		return listProductResponseDTOs;
	}

	@Override
	public void delete(String designation) {
		// TODO Auto-generated method stub
		productRepository.deleteByDesignation(designation);
	}

//	private Product productRequestDTOToProduct(ProductDTO productRequestDTO,Category category) {
//		// TODO Auto-generated method stub
//		Product product = new Product();
//		product.setDesignation(productRequestDTO.getDesignation());
//		product.setPrice(productRequestDTO.getPrice());
//		product.setQuantity(productRequestDTO.getQuantity());
//		product.setDimensions(productRequestDTO.getDimensions());
//		product.setCategory(category);
//		return product;
//	}
//
//	public ProductDTO productToProductResponseDTO(Product product) {
//		// TODO Auto-generated method stub
//		String designation = product.getDesignation();
//		int price = product.getPrice();
//		int quantity = product.getQuantity();
//		String dimensions = product.getDimensions();
//		String categoryName = product.getCategory().getName();
//		return new ProductDTO(null, designation, price, quantity, dimensions, new CategoryDTO(categoryName));
//	}
}
