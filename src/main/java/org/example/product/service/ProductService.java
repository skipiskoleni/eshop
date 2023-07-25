package org.example.product.service;

import org.example.exception.ProductNotFoundException;
import org.example.product.model.Product;
import org.example.product.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductJpaRepository productJpaRepository;

    @Autowired
    public ProductService(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    public void createProduct(Product product) {
        productJpaRepository.save(product);
    }

    public Product getProductById(long id) {
        return productJpaRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("fdsfds")
        );
    }

    public void updateProduct(Product product) {
        productJpaRepository.save(product);
    }

    public void removeProductById(long id) {
        productJpaRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productJpaRepository.findAll();
    }
}
