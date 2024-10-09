package com.tracking.order.Listener;

import com.tracking.order.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @KafkaListener(topics = "order-placed", groupId = "order-consumer-group")
    public void listen(Order order) {
        // Process the order...
        System.out.println("Received Order: " + order);
    }
}
