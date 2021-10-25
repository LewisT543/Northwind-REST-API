package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dto.ProductDTO;
import com.sparta.lt.northwindrest.entities.ProductEntity;
import com.sparta.lt.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProductDTO() {
        try {
            return productRepository.findAll()
                    .stream()
                    .map(this::convertProductEntityToProductDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "resource not found", e);
        }
    }

    public List<ProductDTO> getProductById(Integer productId) {
        try {
            return productRepository.findAll()
                    .stream()
                    .filter(productEntity -> productEntity.getId().equals(productId))
                    .map(this::convertProductEntityToProductDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "product ID not found", e);
        }
    }

    public List<ProductDTO> getProductByName(String productName) {
        try {
            return productRepository.findAll()
                    .stream()
                    .filter(productEntity -> productEntity.getProductName().contains(productName))
                    .map(this::convertProductEntityToProductDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "product name not found", e);
        }
    }

    public List<ProductDTO> getProductsInStock() {
        try {
            return productRepository.findAll()
                    .stream()
                    .filter(productEntity -> productEntity.getUnitsInStock() > 0)
                    .map(this::convertProductEntityToProductDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "", e);
        }
    }

    public List<ProductDTO> getProductsOutOfStock() {
        try {
            return productRepository.findAll()
                    .stream()
                    .filter(productEntity -> productEntity.getUnitsInStock() == 0)
                    .map(this::convertProductEntityToProductDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "", e);
        }
    }

    public List<ProductDTO> getProductsDiscontinued() {
        try {
            return productRepository.findAll()
                    .stream()
                    .filter(ProductEntity::getDiscontinued)
                    .map(this::convertProductEntityToProductDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "", e);
        }
    }

    public List<ProductDTO> getProductsBySupplierId(Integer supplierId) {
        try {
            return productRepository.findAll()
                    .stream()
                    .filter(productEntity -> productEntity.getSupplierID().getId().equals(supplierId))
                    .map(this::convertProductEntityToProductDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "supplier id not found", e);
        }
    }

    public List<ProductDTO> getProductsByCategoryId(Integer categoryId) {
        try {
            return productRepository.findAll()
                    .stream()
                    .filter(productEntity -> productEntity.getCategoryID().getId().equals(categoryId))
                    .map(this::convertProductEntityToProductDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "category id not found", e);
        }
    }

    private ProductDTO convertProductEntityToProductDTO(ProductEntity product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName(product.getProductName());
        productDTO.setSupplierName(product.getSupplierID().getCompanyName());
        productDTO.setCategory(product.getCategoryID().getCategoryName());
        productDTO.setUnitPrice(product.getUnitPrice());
        productDTO.setUnitsInStock(product.getUnitsInStock());
        productDTO.setUnitsOnOrder(product.getUnitsOnOrder());
        productDTO.setReorderLevel(product.getReorderLevel());
        productDTO.setDiscontinued(product.getDiscontinued());
        return productDTO;
    }
}
