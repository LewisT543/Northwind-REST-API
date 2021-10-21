package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dtos.ProductDTO;
import com.sparta.lt.northwindrest.entities.ProductEntity;
import com.sparta.lt.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProductDTO() {
        return productRepository.findAll()
                .stream()
                .map(this::convertProductEntityToProductDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertProductEntityToProductDTO(ProductEntity product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName(product.getProductName());
        productDTO.setSupplierId(product.getSupplierID());
        productDTO.setCategoryId(product.getCategoryID());
        productDTO.setUnitPrice(product.getUnitPrice());
        productDTO.setUnitsInStock(product.getUnitsInStock());
        productDTO.setUnitsOnOrder(product.getUnitsOnOrder());
        productDTO.setReorderLevel(product.getReorderLevel());
        productDTO.setDiscontinued(product.getDiscontinued());
        return productDTO;
    }
}
