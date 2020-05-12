package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository  {
    List<Order> getAllOrders();

    Order save(Order order);

    Optional<Order> findById(Long orderId);
}
