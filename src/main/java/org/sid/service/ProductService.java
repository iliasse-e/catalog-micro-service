package org.sid.service;
import java.util.List;

import org.sid.dto.ProductDTO;

public interface ProductService {
	ProductDTO save(ProductDTO productDTO);
	ProductDTO getProduct(String designation);
	ProductDTO update(ProductDTO updatedProduct, String designation);
	void delete(String designation);
	List<ProductDTO> listProducts();
}
