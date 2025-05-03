// controller/OrderController.java
package com.example.orderservice.controller;

import com.example.orderservice.client.ProductClient;
import com.example.orderservice.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

  private final ProductClient productClient;

  public OrderController(ProductClient productClient) {
    this.productClient = productClient;
  }

  @GetMapping("/orders/{productId}")
  public Product getProductInfo(@PathVariable Long productId) {
    // 通过 Feign 调用商品服务
    return productClient.getById(productId);
  }

  @GetMapping("/orders")
  public List<Product> listProducts() {
    return productClient.list();
  }
}
