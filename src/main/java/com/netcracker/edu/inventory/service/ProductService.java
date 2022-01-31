package com.netcracker.edu.inventory.service;


import com.netcracker.edu.inventory.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    void removeProduct(String productId);

    List<Product> findProducts();

    Product modifyProduct(Product product);
}
