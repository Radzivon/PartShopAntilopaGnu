package by.radzivon.partshop.service.order;

import by.radzivon.partshop.entity.Order;
import by.radzivon.partshop.entity.PairPartQuantity;
import by.radzivon.partshop.exception.ResourceNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order getById(Long id) throws ResourceNotFoundException;
    void save(Order order);
    void annul(Order order);
    void issue(Order order);
    void deleteOrder(Order order);
    List<Order> getAll();
    void editOrder(Order order);
}
