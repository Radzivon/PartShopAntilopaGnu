package by.radzivon.partshop.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping
public class OrderListController {
    @Value("${welcome.message}")
    private String message;
    @GetMapping(value = {"/"})
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", message);
        log.info("/index was called");
        return modelAndView;
    }

//    @GetMapping(value = {"/", "/orders"})
//    public ModelAndView personList(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("personList");
//        model.addAttribute("persons", persons);
//        log.info("/personList - GET was called");
//        return modelAndView;
//    }
}
