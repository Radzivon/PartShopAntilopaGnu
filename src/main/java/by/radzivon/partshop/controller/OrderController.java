package by.radzivon.partshop.controller;

import by.radzivon.partshop.dto.OrderDto;
import by.radzivon.partshop.entity.Order;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.security.UserPrinciple;
import by.radzivon.partshop.service.order.OrderService;
import by.radzivon.partshop.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN') or hasRole('USER')")
    public OrderDto orderById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        log.info("/order/" + id);
        return Mapper.map(orderService.getById(id), OrderDto.class);
    }

    @GetMapping(value = {"/all"}, params = {"page", "pageSize", "sortBy", "order"})
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public Page<OrderDto> findAll(@RequestParam(defaultValue = "0") int pageNo,
                                  @RequestParam(defaultValue = "20") int pageSize,
                                  @RequestParam(defaultValue = "id") String sortBy,
                                  @RequestParam(defaultValue = "asc") String sortDir) {
        log.info("/order/all - GET  was called");
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.fromString(sortDir), sortBy);
        return orderService.getAll(paging).map(this::convertToDto);
    }

    @PostMapping(value = {"/add"})
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN') or hasRole('USER')")
    public void saveOrder(@RequestBody OrderDto orderDto,
                          @AuthenticationPrincipal UserPrinciple userPrinciple) {
        log.info("order/add - POST  was called");
        orderDto.setUserId(userPrinciple.getId());
        orderService.save(Mapper.map(orderDto, Order.class));
    }

    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN') or hasRole('USER')")
    public void editOrder(@PathVariable("id") Long id, @Valid @RequestBody OrderDto orderDto) throws ResourceNotFoundException {
        orderService.editOrder(Mapper.map(orderDto, Order.class));
        log.info("order/edit/" + id);
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN') or hasRole('USER')")
    public void deleteOrder(@PathVariable("id") Long id) throws ResourceNotFoundException {
        orderService.deleteOrder(orderService.getById(id));
        log.info("order/delete/" + id);
    }

    private OrderDto convertToDto(Order order) {
        return Mapper.map(order, OrderDto.class);
    }
}
