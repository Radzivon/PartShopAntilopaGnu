package by.radzivon.partshop.services.order;

import by.radzivon.partshop.entity.Order;
import by.radzivon.partshop.entity.PairPartQuantity;
import by.radzivon.partshop.entity.enums.DeliveryCondition;
import by.radzivon.partshop.entity.enums.OrderCondition;
import by.radzivon.partshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(String name, List<PairPartQuantity> pairPartQuantities, Date deliveryDate, Date dateOfCompletion, String note) {
        Date orderTime = new Date();
        BigDecimal totalCost = calculateTotalCost(pairPartQuantities);
        Order order = Order.builder()
                .name(name)
                .parts(pairPartQuantities)
                .orderTime(orderTime)
                .deliveryDate(deliveryDate)
                .totalCost(totalCost)
                .condition(OrderCondition.ADOPTED)
                .dateOfCompletion(dateOfCompletion)
                .note(note)
                .deliveryCondition(DeliveryCondition.ON_THE_WAY)
                .build();

        return order;
    }

    @Override
    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
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
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    private BigDecimal calculateTotalCost(List<PairPartQuantity> parts) {
        BigDecimal totalCost = new BigDecimal(0);
        for (PairPartQuantity pairPartQuantity : parts) {
            totalCost = pairPartQuantity.getPart().getPrice().multiply(BigDecimal.valueOf(pairPartQuantity.getQuantity()));
        }
        return totalCost;
    }
}
