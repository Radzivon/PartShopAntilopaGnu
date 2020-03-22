package by.radzivon.partshop.services.order;

import by.radzivon.partshop.entity.Order;
import by.radzivon.partshop.entity.PairPartQuantity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(String name, List<PairPartQuantity> pairPartQuantities, Date deliveryDate,
                      Date dateOfCompletion, String note);
    Optional<Order> getById(Long id);
    void save(Order order);
    void annul(Order order);
    void issue(Order order);
    void deleteOrder(Order order);
    List<Order> getAll();
}
