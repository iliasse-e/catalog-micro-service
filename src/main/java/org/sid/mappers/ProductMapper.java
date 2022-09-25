package org.sid.mappers;

import org.mapstruct.Mapper;
import org.sid.dto.ProductDTO;
import org.sid.entities.product.Product;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProductMapper {
	ProductDTO productToProductResponseDTO(Product product);
	Product productRequestDTOToProduct(ProductDTO productRequestDTO);
}
