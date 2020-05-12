package project.repository.InMemoryImpl;

import org.springframework.stereotype.Repository;
import project.bootstrap.DataHolder;
import project.model.Order;
import project.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryOrderRepositoryImpl implements OrderRepository {

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(DataHolder.orders);
    }

    @Override
    public Order save(Order order) {
        DataHolder.orders.add(order);
        return order;
    }

    @Override
    public Optional<Order> findById(Long orderId) {
        return Optional.empty();
    }
}
