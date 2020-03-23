package by.radzivon.partshop.controller;

import by.radzivon.partshop.exceptions.NoSuchEntityException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping(value = {"/", "index"})
    public ModelAndView partsPage() throws NoSuchEntityException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
