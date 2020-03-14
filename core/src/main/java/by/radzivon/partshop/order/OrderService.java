package by.radzivon.partshop.order;

import by.shop.part.Part;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderService {
    Order create(List<PairPartQuantity> orderItems, String name, LocalDate orderTime, Long customerId);
    Optional<Order> findById(final Long id);
    void edit(Order order);
    void annul(Order order);
    void issue(Order order, OrderCondition orderCondition);
    List<Order> findAll();
}
