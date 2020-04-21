package by.radzivon.partshop.service.order;

import by.radzivon.partshop.entity.Order;
import by.radzivon.partshop.entity.enums.OrderCondition;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getById(Long id) throws ResourceNotFoundException {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " exist"));
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }


    @Override
    public void annul(Order order) {
        order.setCondition(OrderCondition.ANNUL);
        orderRepository.save(order);
    }

    @Override
    public void issue(Order order) {
        order.setCondition(OrderCondition.ADOPTED);
        orderRepository.save(order);
    }

    @Override
    public Page<Order> getAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public void editOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }
}
