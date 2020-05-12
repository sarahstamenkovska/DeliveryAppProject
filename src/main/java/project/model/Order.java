package project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.*;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {

    private String clientName;
    private String clientAddress;
    private String clientPhone;
    @Id
    private Long orderId;

    private Bread bread;

    public Bread getBread() {
       return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }


    private Burger burger;

    public Burger getBurger() {
        return burger;
    }

    public void setBurger(Burger burger) {
        this.burger = burger;
    }




    public Order() {

    }

    public Order(Burger burger, String clientName, String clientAddress,String clientPhone, Long OrderId) {
        this.burger = burger;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientPhone = clientPhone;
        this.orderId = OrderId;
    }




    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
