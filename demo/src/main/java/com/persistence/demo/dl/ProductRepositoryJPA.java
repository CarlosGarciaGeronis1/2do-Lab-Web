package com.persistence.demo.dl;

import java.util.ArrayList;
import java.util.List;
import com.persistence.demo.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryJPA implements ProductRepository {

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Override
    public Product findProduct(Long id) {
        var entity = productEntityRepository.findById(id).get();
        return new Product(entity.getId(), entity.getName(), entity.getBrand(), entity.getMadein(), entity.getPrice());
    }

    @Override
    public void saveProduct(Product product) {
        var entity = new ProductEntity();
        entity.setName(product.getName());
        entity.setBrand(product.getBrand());
        entity.setMadein(product.getMadein());
        entity.setPrice(product.getPrice());

        productEntityRepository.save(entity);
    }

    @Override
    public void deleteProduct(Long id) {
        productEntityRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Product product) {

        var entity = productEntityRepository.findById(product.getId()).get();

        entity.setName(product.getName());
        entity.setBrand(product.getBrand());
        entity.setPrice(product.getPrice());

        productEntityRepository.save(entity);
    }

    public List<Product> findAllProducts() {
        var entities = productEntityRepository.findAll();

        var products = new ArrayList<Product>();

        for (ProductEntity entity : entities) {
            products.add(new Product(entity.getId(), entity.getName(), entity.getBrand(), entity.getMadein(),
                    entity.getPrice()));
        }

        return products;
    }

}
