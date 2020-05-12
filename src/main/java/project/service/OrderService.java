package project.service;

import project.model.Burger;
import project.model.Order;

public interface OrderService {

    Order placeOrder(Burger burger, String clientName, String address, String phone);

}
