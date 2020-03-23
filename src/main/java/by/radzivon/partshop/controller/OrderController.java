package by.radzivon.partshop.controller;

import by.radzivon.partshop.dto.OrderDto;
import by.radzivon.partshop.entity.Order;
import by.radzivon.partshop.entity.PairPartQuantity;
import by.radzivon.partshop.entity.User;
import by.radzivon.partshop.exceptions.NoSuchEntityException;
import by.radzivon.partshop.service.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@Slf4j
public class OrderController {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order/{id}")
    public ModelAndView orderPage(@PathVariable("id") Long id) throws NoSuchEntityException {
        Order order = orderService.getById(id).orElseThrow(() -> new NoSuchEntityException("Part not found"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order");
        modelAndView.addObject("order", order);
        log.info("/order{" + id + "} - GET  was called");
        return modelAndView;
    }

    @GetMapping(value = {"/orders"})
    public ModelAndView ordersPage() throws NoSuchEntityException {
        List<Order> orders = orderService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders");
        modelAndView.addObject("orders", orders);
        log.info("/orders - GET  was called");
        return modelAndView;
    }

    @GetMapping(value = {"/newOrder"})
    public ModelAndView showNewOrderPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("newOrder");
        OrderDto orderDto = new OrderDto();
        modelAndView.addObject("orderDto", orderDto);
        log.info("/newOrder - GET  was called");
        return modelAndView;
    }

    @PostMapping(value = {"/newOrder"})
    public ModelAndView saveOrder(Model model,
                                  @Valid @ModelAttribute("orderDto") OrderDto orderDto,
                                  Errors errors,
                                  SessionStatus sessionStatus,
                                  @AuthenticationPrincipal User user) {
        ModelAndView modelAndView = new ModelAndView();
        log.info("/newOrder - POST  was called" + orderDto);
        if (errors.hasErrors()) {
            modelAndView.addObject("errors", errors);
            modelAndView.setViewName("newOrder");
            log.warn("/newOrder - POST  has error");
        } else {
            String name = orderDto.getName();
            List<PairPartQuantity> partQuantityList = orderDto.getParts();
            partQuantityList = new ArrayList<>();
            Date dateOfCompletion = orderDto.getDateOfCompletion();
            Date deliveryDate = orderDto.getDeliveryDate();
            String note = orderDto.getNote();

            Order order = orderService.createOrder(name, partQuantityList, deliveryDate, dateOfCompletion, note);
            order.setUser(user);

            modelAndView.setViewName("confirmOrder");
            modelAndView.addObject("order", order);

            log.info("/newOrder - POST  was called");
            return modelAndView;
        }
        return modelAndView;
    }

    @GetMapping(value = "/editOrder/{id}")
    public ModelAndView editPage(@PathVariable("id") Long id) throws NoSuchEntityException {
        Order order = orderService.getById(id).orElseThrow(() -> new NoSuchEntityException("Part not found"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editOrder");
        modelAndView.addObject("order", order);
        log.info("/editOrder" + id + "} - GET  was called");
        return modelAndView;
    }

    @GetMapping(value = "/confirmOrder")
    public ModelAndView confirmOrderPage(@ModelAttribute("order") Order order) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirmOrder");
        modelAndView.addObject("order", order);
        log.info("/confirmOrder - GET  was called");
        return modelAndView;
    }

    @PostMapping(value = "/confirmOrder")
    public ModelAndView confirmOrder(@ModelAttribute("order") Order order,
                                     Errors errors,
                                     SessionStatus sessionStatus,
                                     @AuthenticationPrincipal User user) {
        log.info("/confirmOrder - POST  was called" + order);
        order.setUser(user);
        orderService.save(order);
        sessionStatus.setComplete();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel();
        modelAndView.setViewName("redirect:/orders");

        return modelAndView;
    }

    @PostMapping(value = "/editOrder")
    public ModelAndView editPerson(@Valid @ModelAttribute("order") Order order,
                                   Errors errors) {
        log.info("/editOrder - POST  was called" + order);
        orderService.save(order);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/orders");

        return modelAndView;
    }
}
