package by.radzivon.partshop.controller;

import by.radzivon.partshop.dto.OrderDto;
import by.radzivon.partshop.entity.Order;
import by.radzivon.partshop.entity.User;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.service.order.OrderService;
import by.radzivon.partshop.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{id}")
    public OrderDto orderById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        log.info("/order/" + id);
        return Mapper.map(orderService.getById(id), OrderDto.class);
    }

    @GetMapping(value = {"/all"})
    public List<OrderDto> findAll() {
        log.info("/order/all - GET  was called");
        return Mapper.mapAll(orderService.getAll(), OrderDto.class);
    }

    @PostMapping(value = {"/add"})
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrder(Model model,
                          @Valid @ModelAttribute("orderDto") OrderDto orderDto,
                          SessionStatus sessionStatus,
                          @AuthenticationPrincipal User userDto) {
        log.info("order/add - POST  was called");
        Order order = new Order();
        //order.setUser(user);
        orderService.save(order);
    }

    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editOrder(@PathVariable("id") Long id, @Valid @RequestBody OrderDto orderDto) throws ResourceNotFoundException {
        orderService.editOrder(Mapper.map(orderDto, Order.class));
        log.info("order/edit/" + id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteOrder(@PathVariable("id") Long id) throws ResourceNotFoundException {
        orderService.deleteOrder(orderService.getById(id));
        log.info("order/delete/" + id);
    }
}
