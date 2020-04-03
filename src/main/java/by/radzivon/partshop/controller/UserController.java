package by.radzivon.partshop.controller;

import by.radzivon.partshop.dto.BrandDto;
import by.radzivon.partshop.dto.UserDto;
import by.radzivon.partshop.entity.User;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class UserController {
//
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping(value = "/{id}")
//    public UserDto userPage(@PathVariable("id") Long id) throws ResourceNotFoundException {
//        log.info("user/" + id);
//        return Mapper.map(userService.getById(id), UserDto.class);
//    }
//
//    @GetMapping(value = {"/all"})
//    public @ResponseBody
//    List<UserDto> userList() {
//        log.info("user/all");
//        return Mapper.mapAll(userService.getAll(), UserDto.class);
//    }
//
//    @PostMapping(value = {"/add"})
//    @ResponseStatus(HttpStatus.CREATED)
//    public void saveUser(@Valid @RequestBody UserDto brandDto) {
//        userService.save(Mapper.map(brandDto, User.class));
//        log.info("user/add");
//
//    }
//
//    @PutMapping(value = "/edit/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void editUser(@PathVariable("id") Long id, @RequestBody BrandDto brandDto) {
//        userService.update(Mapper.map(brandDto, User.class));
//        log.info("user/edit/" + id);
//    }
//
//    @DeleteMapping(value = "/delete/{id}")
//    public void deletePerson(@PathVariable("id") Long id) throws ResourceNotFoundException {
//        User user = userService.getById(id);
//        userService.deleteUser(user);
//        log.info("user/delete with id " + id);
//    }
}

