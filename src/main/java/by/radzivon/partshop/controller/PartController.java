package by.radzivon.partshop.controller;

import by.radzivon.partshop.dto.PartDto;
import by.radzivon.partshop.entity.Part;
import by.radzivon.partshop.entity.Stock;
import by.radzivon.partshop.entity.enums.PartCondition;
import by.radzivon.partshop.exceptions.NoSuchEntityException;
import by.radzivon.partshop.services.part.PartService;
import by.radzivon.partshop.services.part.PartServiceImpl;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class PartController {

    private PartService partService;

    @Autowired
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @GetMapping(value = "/part/{id}")
    public Part partPage(@PathVariable("id") Long id) throws NoSuchEntityException {
        return partService.getById(id).orElseThrow(() -> new NoSuchEntityException("Part not found"));
    }

    @GetMapping(value = {"/parts"})
    public ModelAndView partsPage() throws NoSuchEntityException {
        List<Part> parts = partService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("parts");
        modelAndView.addObject("parts", parts);
        return modelAndView;
    }

    @GetMapping(value = {"/addPart"})
    public ModelAndView showAddPersonPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("addPart");
        PartDto personForm = new PartDto();
        modelAndView.addObject("partForm", personForm);
        modelAndView.addObject("partCondition", listPartCondition());
        log.info("/addPart - GET  was called");
        return modelAndView;
    }

    @PostMapping(value = {"/addPart"})
    public ModelAndView savePart(Model model,
                                 @Valid @ModelAttribute("personForm") PartDto partDto,
                                 Errors errors) {
        ModelAndView modelAndView = new ModelAndView();
        log.info("/addPart - POST  was called" + partDto);
        if (errors.hasErrors()) {
            modelAndView.addObject("errors", errors);
            modelAndView.setViewName("addPart");
            log.warn("/addPart - POST  has error");
        } else {
            modelAndView.setViewName("parts");
            String category = partDto.getCategory();
            String brand = partDto.getBrand();
            String partModel = partDto.getModel();
            BigDecimal price = partDto.getPrice();
            int stock = partDto.getStock();
//            List<Photo> photos = partDto.getPhotos();
            Date realiseDate = partDto.getRealiseDate();
            PartCondition partCondition = partDto.getCondition();
            String description = partDto.getDescription();


            Part newPart = Part.builder()
                    .category(category)
                    .brand(brand)
                    .model(partModel)
                    .price(price)
                    .stock(stock)
                    .realiseDate(realiseDate)
                    .condition(partCondition)
                    .description(description)
                    .build();

            partService.save(newPart);

            model.addAttribute("parts", partService.getAll());
            log.info("/addPerson - POST  was called");
            return modelAndView;
        }
        return modelAndView;
    }

    @GetMapping(value = "/editPart/{id}")
    public ModelAndView editPage(@PathVariable("id") Long id) throws NoSuchEntityException {
        Part part = partService.getById(id).orElseThrow(() -> new NoSuchEntityException("Part not found"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPart");
        modelAndView.addObject("part", part);
        return modelAndView;
    }

    @PostMapping(value = "/editPart")
    public ModelAndView editPerson(@Valid @ModelAttribute("part") Part part,
                                   Errors errors) {
        log.info("/editPart - POST  was called" + part);
        partService.save(part);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/parts");

        return modelAndView;
    }

    @GetMapping(value = "/deletePart/{id}")
    public ModelAndView deletePerson(@PathVariable("id") Long id) throws NoSuchEntityException {
        Part part = partService.getById(id).orElseThrow(() -> new NoSuchEntityException("Part not found"));
        partService.deletePart(part);
        log.info("deletePerson with id " + id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/parts");
        return modelAndView;
    }


    public List<PartCondition> listPartCondition() {
        return Arrays.asList(PartCondition.values());
    }
}
