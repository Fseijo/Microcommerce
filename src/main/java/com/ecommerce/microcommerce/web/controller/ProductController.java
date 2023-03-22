package com.ecommerce.microcommerce.web.controller;


import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.web.dao.ProductDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {

    private final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/Produits")
    public List<Product> listeProduits(){
        return productDao.findAll();
    }

    @GetMapping(value = "/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id){
        return productDao.findById(id);
    }

    @PostMapping(value = "/Produits")
    public ResponseEntity<Product> ajouterProduit(@RequestBody Product product) {
        Product productAdded = productDao.save(product);
        if (Objects.isNull(productAdded)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
