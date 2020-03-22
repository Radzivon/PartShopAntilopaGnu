package by.radzivon.partshop.repository;

import by.radzivon.partshop.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAll();
    void delete(Order order);
    Order save(Order order);
    Optional<Order> findById(Long id);
}
