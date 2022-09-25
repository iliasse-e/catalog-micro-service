package org.sid.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.sid.dao.ProductRepository;
import org.sid.dto.ProductDTO;
import org.sid.entities.product.Product;
import org.sid.mappers.ProductMapperImpl;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private ProductMapperImpl productMapperImpl;
	
	public ProductServiceImpl(ProductRepository productRepository, ProductMapperImpl productMapperImpl) {
		this.productRepository = productRepository;
		this.productMapperImpl = productMapperImpl;
	}

	@Override
	public ProductDTO save(ProductDTO productRequestDTO) {
		// TODO Auto-generated method stub
		Product product = productMapperImpl.productRequestDTOToProduct(productRequestDTO);
		Product savedProduct = productRepository.save(product);
		ProductDTO productResponseDTO = productMapperImpl.productToProductResponseDTO(savedProduct);
		
		return productResponseDTO;
	}

	@Override
	public ProductDTO getProduct(Long productId) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(productId).get();
		return productMapperImpl.productToProductResponseDTO(product);
	}

	@Override
	public ProductDTO update(ProductDTO productRequestDTO) {
		// TODO Auto-generated method stub
		Product product = productMapperImpl.productRequestDTOToProduct(productRequestDTO);
		Product updatedProduct = productRepository.save(product);
		return productMapperImpl.productToProductResponseDTO(updatedProduct);
	}

	@Override
	public List<ProductDTO> listProducts() {
		// TODO Auto-generated method stub
		List<Product> listProducts = productRepository.findAll();
		List<ProductDTO> listProductResponseDTOs = listProducts
				.stream()
				.map(p -> productMapperImpl.productToProductResponseDTO(p))
				.collect(Collectors.toList());
		return listProductResponseDTOs;
	}

	@Override
	public void delete(Long productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
		
	}
}
