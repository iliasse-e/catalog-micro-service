//package org.sid.mappers;
//
//import org.sid.dao.CategoryRepository;
//import org.sid.dto.CategoryDTO;
//import org.sid.dto.ProductDTO;
//import org.sid.entities.category.Category;
//import org.sid.entities.product.Product;
//import org.springframework.stereotype.Component;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Data @AllArgsConstructor
//@Component
//public class ProductMapperImpl implements ProductMapper {
//
//	private final CategoryRepository categoryRepository;
//
//	@Override
//    public Product productRequestDTOToProduct(ProductDTO productRequestDTO,Category category) {
//        // TODO Auto-generated method stub
//        Product product = new Product();
//        product.setDesignation(productRequestDTO.getDesignation());
//        product.setPrice(productRequestDTO.getPrice());
//        product.setQuantity(productRequestDTO.getQuantity());
//        product.setDimensions(productRequestDTO.getDimensions());
//        product.setCategory(category);
//        return product;
//    }
//
//    @Override
//    public ProductDTO productToProductResponseDTO(Product product) {
//        // TODO Auto-generated method stub
//        String designation = product.getDesignation();
//        int price = product.getPrice();
//        int quantity = product.getQuantity();
//        String dimensions = product.getDimensions();
//        String categoryName = product.getCategory().getName();
//        return new ProductDTO(designation, price, quantity, dimensions, new CategoryDTO(categoryName));
//    }
//
//}
