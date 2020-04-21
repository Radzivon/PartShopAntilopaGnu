package by.radzivon.partshop.controller;

import by.radzivon.partshop.dto.PartDto;
import by.radzivon.partshop.dto.UserPartDto;
import by.radzivon.partshop.entity.UserPart;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.service.userpart.UserPartService;
import by.radzivon.partshop.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "user/part")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class UserPartController {
    private UserPartService partService;

    @Autowired
    public UserPartController(UserPartService partService) {
        this.partService = partService;
    }

    @GetMapping(value = "/{id}")
    public UserPartDto partPage(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return Mapper.map(partService.getById(id), UserPartDto.class);
    }

    @GetMapping(value = {"/all"})
    public @ResponseBody
    List<UserPartDto> partsPage() {
        return Mapper.mapAll(partService.getAll(), UserPartDto.class);
    }

    @PostMapping(value = {"/add"})
    @ResponseStatus(HttpStatus.CREATED)
    public void savePart(@Valid @RequestBody UserPartDto partDto) {
        partService.save(Mapper.map(partDto, UserPart.class));
        log.info("user/part/add");

    }

    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editPart(@PathVariable("id") Long id, @Valid @RequestBody PartDto partDto) {
        partService.editPart(Mapper.map(partDto, UserPart.class));
        log.info("user/part/edit with id " + id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePerson(@PathVariable("id") Long id) throws ResourceNotFoundException {
        UserPart part = partService.getById(id);
        partService.deletePart(part);
        log.info("user/part/delete with id " + id);
    }
}
