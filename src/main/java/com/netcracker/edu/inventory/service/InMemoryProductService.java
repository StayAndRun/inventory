package com.netcracker.edu.inventory.service;

import com.netcracker.edu.inventory.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InMemoryProductService implements ProductService {

    private final List<Product> products = new ArrayList<>();

    @Override
    public Product createProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
        products.add(product);
        return product;
    }

    @Override
    public void removeProduct(String productId) {
        searchProduct(productId).forEach(products::remove);
    }

    @Override
    public List<Product> findProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product modifyProduct(Product newProduct) {
        List<Product> currentProduct = searchProduct(newProduct.getId());
        products.set(products.indexOf(currentProduct), newProduct);
        return newProduct;
    }

    private List<Product> searchProduct(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .collect(Collectors.toList());
    }
}
