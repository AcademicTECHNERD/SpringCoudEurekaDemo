package com.example.productservice.controller;

import com.example.productservice.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

  // 模拟数据
  private static final List<Product> PRODUCTS = Arrays.asList(
          new Product(1L, "苹果", 5.0),
          new Product(2L, "香蕉", 2.5),
          new Product(3L, "橙子", 3.5)
  );

  @GetMapping("/products")
  public List<Product> list() {
    return PRODUCTS;
  }

  @GetMapping("/products/{id}")
  public Product byId(@PathVariable("id") Long id) {
    return PRODUCTS.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElse(null);
  }
}