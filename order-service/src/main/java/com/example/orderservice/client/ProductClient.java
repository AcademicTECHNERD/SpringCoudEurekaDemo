// client/ProductClient.java
package com.example.orderservice.client;

import com.example.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductClient {

  @GetMapping("/products")
  List<Product> list();

  @GetMapping("/products/{id}")
  Product getById(@PathVariable("id") Long id);
}
