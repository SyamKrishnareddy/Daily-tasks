package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.model.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final WebClient webClient;

    public OrderController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
    }

    @PostMapping
    public Mono<Order> createOrder(@RequestParam String productId) {
        Order order = new Order(UUID.randomUUID().toString(), productId);

        // Asynchronous call to Product Service to get product details
        Mono<Product> productMono = webClient.get()
                .uri("/products/{id}", productId)
                .retrieve()
                .bodyToMono(Product.class);

        return productMono.map(product -> {
            order.setProductName(product.getName());
            order.setProductPrice(product.getPrice());
            order.setStatus("CONFIRMED");
            return order;
        });
    }
}
