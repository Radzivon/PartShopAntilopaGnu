package by.radzivon.partshop.order;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order create(List<PairPartQuantity> orderItems, String name, LocalDate orderTime, Long customerId) {
        //TODO
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        //TODO
        return Optional.empty();
    }

    @Override
    public void edit(Order order) {
        //TODO
    }

    @Override
    public void annul(Order order) {
        //TODO
    }

    @Override
    public void issue(Order order, OrderCondition orderCondition) {
        //TODO
    }

    @Override
    public List<Order> findAll() {
        //TODO
        return null;
    }
}
