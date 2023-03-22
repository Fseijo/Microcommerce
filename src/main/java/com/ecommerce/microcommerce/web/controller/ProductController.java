package com.ecommerce.microcommerce.web.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/Produits")
    public String listeProduits()
    {
        return "Un exemple de produit";
    }

    @GetMapping("/Produits/{id}")
    public String afficherUnProduit(@PathVariable int id)
    {
        return "Vous avez demandé in produit avec l'id " + id;
    }


}
