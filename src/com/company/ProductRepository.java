package com.company;

import Model.Product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductRepository implements IProductManager {

    private final ArrayList<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void update(String targetId, Product newProduct) {
        for (Product product : products) {
            if (product.getId().equals(targetId)) {
                int index = products.indexOf(product);
                products.set(index, newProduct);
            }
        }
    }

    @Override
    public void delete(String targetId) {
        products.removeIf(item -> item.getId().equals(targetId));
    }

    @Override
    public void deleteAll() {
        products.clear();
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product findById(String targetId) {
        for (Product product : products) {
            if (product.getId().equals(targetId)) {
                return product;
            }
        }

        return null;
    }

    public void showWithMessage(String message) {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + 1 + " ↓ " + products.get(i));

        }
        System.out.println(message);
    }


    public void showWithDate() {
        for (int i = 0; i < products.size(); i++) {
            Date date = new Date();
            Product product = products.get(i);
            date.setTime(product.getPublishDateInMillis());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy  HH:mm");

            System.out.println((i + 1 + "-" + product + " (" + dateFormat.format(date)) + ")");
        }
    }
}
