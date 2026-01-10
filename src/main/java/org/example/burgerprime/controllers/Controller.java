package org.example.burgerprime.controllers;

import org.example.burgerprime.interfaces.AccountRepository;
import org.example.burgerprime.interfaces.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.example.burgerprime.models.Account;
import org.example.burgerprime.models.Image;
import org.example.burgerprime.models.Product;
import org.example.burgerprime.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Controller

@RequiredArgsConstructor
public class Controller {

    @Autowired
    public final ProductRepository productRepository;
    public final Service service;
    public final AccountRepository accountRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "index";
    }
    @GetMapping("/add/product")
    public String addProduct() {

        return "add_product";
    }

    @PostMapping("/add/product")
    public String addProduct( @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                              @RequestParam("file3") MultipartFile file3, Product product) throws IOException {

        service.saveProduct(product, file1, file2, file3);

        return "redirect:/add/product";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Integer id, Model model) {
        Product product = productRepository.getProductById(id);
        model.addAttribute("products", product);
        model.addAttribute("images", product.getImages());
        return "product_info";
    }

}
