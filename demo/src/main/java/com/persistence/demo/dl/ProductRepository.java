package com.persistence.demo.dl;

import java.util.List;

import com.persistence.demo.domain.Product;

public interface ProductRepository {

    public Product findProduct(Long Id);

    public void saveProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(Long id);

    public List<Product> findAllProducts();

}