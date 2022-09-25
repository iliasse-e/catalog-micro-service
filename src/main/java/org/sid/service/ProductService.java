package org.sid.service;
import java.util.List;

import org.sid.dto.ProductDTO;

public interface ProductService {
	ProductDTO save(ProductDTO productRequestDTO);
	ProductDTO getProduct(Long ProductId);
	ProductDTO update(ProductDTO productRequestDTO);
	void delete(Long productId);
	List<ProductDTO> listProducts();

}
