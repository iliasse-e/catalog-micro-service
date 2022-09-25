//package org.sid.mappers;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.sid.dto.ProductDTO;
//import org.sid.entities.category.Category;
//import org.sid.entities.product.Product;
//import org.springframework.stereotype.Component;
//
//@Mapper(componentModel = "productMapper", uses = CategoryMapper.class)
//@Component
//public interface ProductMapper {
//
//	ProductDTO productToProductResponseDTO(Product product);
//	@Mapping(target = "id", ignore = true)
//	Product productRequestDTOToProduct(ProductDTO productRequestDTO, Category category);
//}
