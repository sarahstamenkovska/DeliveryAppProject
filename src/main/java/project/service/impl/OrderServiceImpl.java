package project.service.impl;

import org.springframework.stereotype.Service;
import project.model.Burger;
import project.model.Order;
import project.repository.OrderRepository;
import project.service.OrderService;

import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(Burger burger, String clientName, String address, String phone) {
        System.out.println("[WP-Log] placeOrder from OrderServiceImpl");
        Order order= new Order(burger, clientName,address,phone,new Random().nextLong());
        return this.orderRepository.save(order);
    }
}
