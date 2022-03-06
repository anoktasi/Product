package com.company;

import Model.Product;

import java.util.List;

public interface IProductManager {
    void add(Product product);

    void update(String targetIndex, Product newProduct);

    void delete(String targetId);

    void deleteAll();

    List<Product> getAll();

    Product findById(String targetId);
}
