package com.persistence.demo.bl;

import java.util.List;

import com.persistence.demo.domain.Product;

public interface ProductManagement {

    public void AddProduct(Product product);

    public List<Product> GetAllProducts();

}
