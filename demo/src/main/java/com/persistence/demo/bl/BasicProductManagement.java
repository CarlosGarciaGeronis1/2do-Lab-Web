package com.persistence.demo.bl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.persistence.demo.dl.ProductRepository;
import com.persistence.demo.domain.Product;

@Component
public class BasicProductManagement implements ProductManagement {

    // Repositories
    private ProductRepository productRepository;

    // Recibir repositorios de customer, items, shoppingCart
    public BasicProductManagement(ProductRepository productRepository) { // se reciben
        this.productRepository = productRepository;
    }

    public void AddProduct(Product product) {
        productRepository.saveProduct(product);
    }

    public List<Product> GetAllProducts() {
        return productRepository.findAllProducts();
    }

}
