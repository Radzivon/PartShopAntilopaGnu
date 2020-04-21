package by.radzivon.partshop.service.order;

import by.radzivon.partshop.entity.Order;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Order getById(Long id) throws ResourceNotFoundException;
    void save(Order order);
    void annul(Order order);
    void issue(Order order);
    void deleteOrder(Order order);
    Page<Order> getAll(Pageable pageable);
    void editOrder(Order order);
}
