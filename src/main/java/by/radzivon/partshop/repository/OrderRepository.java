package by.radzivon.partshop.repository;

import by.radzivon.partshop.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
    Page<Order> findAll(Pageable pageable);
    void delete(Order order);
    Order save(Order order);
    Optional<Order> findById(Long id);
}
