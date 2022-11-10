package org.sid.mappers;

import org.mapstruct.Mapper;
import org.sid.dto.ProductDTO;
import org.sid.entities.category.Category;
import org.sid.entities.product.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	ProductDTO productToProductDTO(Product product);

	Product productDTOToProduct(ProductDTO productDTO);
}
