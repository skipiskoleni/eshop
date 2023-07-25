package org.example.order.service;

import org.example.exception.OrderNotFoundException;
import org.example.order.entity.Order;
import org.example.order.repository.OrderJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderJpaRepository orderJpaRepository;

    public OrderService(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    public List<Order> getAllOrders() {
        return  orderJpaRepository.findAll();
    }

    public Order getOrderById(long id) {
        return orderJpaRepository.findById(id).orElseThrow(
                () -> new OrderNotFoundException(String.format("Order with id %d was not found.", id))
        );
    }

    public Order createOrder(Order order) {
        return  orderJpaRepository.save(order);
    }
}
