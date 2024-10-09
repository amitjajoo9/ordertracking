package com.tracking.order.service;

import com.tracking.order.model.Order;
import com.tracking.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public Order createOrder(Order order) {
       order.setStatus("PLACED");// Set the status
        Order savedOrder = orderRepository.save(order);
        kafkaTemplate.send("order-placed", savedOrder);
        return savedOrder;
    }
}

