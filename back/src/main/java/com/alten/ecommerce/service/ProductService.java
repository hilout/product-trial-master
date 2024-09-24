
package com.alten.ecommerce.service;

import com.alten.ecommerce.model.Product;
import com.alten.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.copy(product);
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
