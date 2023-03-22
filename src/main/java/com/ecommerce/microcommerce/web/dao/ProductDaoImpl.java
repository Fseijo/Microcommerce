package com.ecommerce.microcommerce.web.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDao{
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Ordinateur Portable ", 350, 120));
        products.add(new Product(2, "Aspirateur Robbot ", 500, 200));
        products.add(new Product(3, "Table de Ping Pong ", 750, 400));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
