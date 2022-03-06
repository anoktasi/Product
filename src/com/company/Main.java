package com.company;

import Model.Product;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        ProductRepository repository = new ProductRepository();
        Scanner menu = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose an operation: ");
            System.out.println
                    ("1-) Add product\n" +
                            "2-) Update product\n" +
                            "3-) Delete product\n" +
                            "4-) Delete all Products\n" +
                            "5-) List all products\n" +
                            "6-) Find product\n");
            int select = Integer.parseInt(menu.next());
            switch (select) {
                case 1: {
                    String id = UUID.randomUUID().toString().replace("-", "");
                    Product newProduct = new Product(id);

                    System.out.println("Enter product name:");
                    newProduct.setName(menu.next());

                    System.out.println("Enter product description:");
                    newProduct.setDescription(menu.next());

                    System.out.println("Enter product price:");
                    newProduct.setPrice(Integer.parseInt(menu.next()));

                    System.out.println("Enter product stock amount");
                    newProduct.setStockAmount(Integer.parseInt(menu.next()));

                    newProduct.setPublishDateInMillis(System.currentTimeMillis());

                    repository.add(newProduct);

                    System.out.println("Product added");
                    repository.showWithDate();
                    break;
                }
                case 2: {
                    if (repository.getAll().isEmpty()) {
                        System.out.println("There is no any product");
                        break;
                    }
                    repository.showWithMessage("Select the product to be update");

                    int index = Integer.parseInt(menu.next()) - 1;
                    String targetId = repository.getAll().get(index).getId();

                    Product newProduct = new Product(targetId);
                    newProduct.setPublishDateInMillis(System.currentTimeMillis());
                    System.out.println("Enter product name:");
                    String updatedName = menu.next();
                    newProduct.setName(updatedName);

                    System.out.println("Enter product description:");
                    String updatedDescription = menu.next();
                    newProduct.setDescription(updatedDescription);

                    System.out.println("Enter product price:");
                    double updatedPrice = Integer.parseInt(menu.next());
                    newProduct.setPrice(updatedPrice);

                    System.out.println("Enter product stock amount");
                    int updatedStockAmount = Integer.parseInt(menu.next());
                    newProduct.setStockAmount(updatedStockAmount);

                    repository.getAll().set(index, newProduct);
                    System.out.println(newProduct);
                    System.out.println("Product updated");
                    repository.showWithDate();
                    break;
                }
                case 3: {
                    if (repository.getAll().isEmpty()) {
                        System.out.println("There is no any product");
                        break;
                    }
                    repository.showWithMessage("Select the product to be delete");
                    int index = Integer.parseInt(menu.next()) - 1;
                    String targetId = repository.getAll().get(index).getId();
                    repository.delete(targetId);
                    System.out.println("Product deleted");
                    break;
                }
                case 4: {
                    if (repository.getAll().isEmpty()) {
                        System.out.println("There is no any product");
                        break;
                    }
                    repository.deleteAll();
                    System.out.println("All product deleted");
                    break;
                }
                case 5: {
                    if (repository.getAll().isEmpty()) {
                        System.out.println("There is no any product");
                        break;
                    }
                    repository.showWithDate();
                    break;
                }
                case 6: {
                    if (repository.getAll().isEmpty()) {
                        System.out.println("There is no any product");
                        break;
                    }
                    System.out.println("Enter index which you want to show");
                    int index = Integer.parseInt(menu.next()) - 1;
                    String targetId = repository.getAll().get(index).getId();

                    System.out.println(repository.findById(targetId));

                    break;
                }
            }

        }
    }
}
