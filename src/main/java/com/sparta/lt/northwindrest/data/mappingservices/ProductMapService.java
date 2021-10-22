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

    public List<ProductDTO> getProductById(Integer productId) {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getId().equals(productId))
                .map(this::convertProductEntityToProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByName(String productName) {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getProductName().contains(productName))
                .map(this::convertProductEntityToProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsInStock() {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getUnitsInStock() > 0)
                .map(this::convertProductEntityToProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsOutOfStock() {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getUnitsInStock() == 0)
                .map(this::convertProductEntityToProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsDiscontinued() {
        return productRepository.findAll()
                .stream()
                .filter(ProductEntity::getDiscontinued)
                .map(this::convertProductEntityToProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsBySupplierId(Integer supplierId) {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getSupplierID().getId().equals(supplierId))
                .map(this::convertProductEntityToProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsByCategoryId(Integer categoryId) {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getCategoryID().getId().equals(categoryId))
                .map(this::convertProductEntityToProductDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertProductEntityToProductDTO(ProductEntity product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName(product.getProductName());
        productDTO.setSupplierId(product.getSupplierID().getId());
        productDTO.setCategoryId(product.getCategoryID().getId());
        productDTO.setUnitPrice(product.getUnitPrice());
        productDTO.setUnitsInStock(product.getUnitsInStock());
        productDTO.setUnitsOnOrder(product.getUnitsOnOrder());
        productDTO.setReorderLevel(product.getReorderLevel());
        productDTO.setDiscontinued(product.getDiscontinued());
        return productDTO;
    }
}
