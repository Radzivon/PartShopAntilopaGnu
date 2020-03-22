package by.radzivon.partshop.controller;

import by.radzivon.partshop.entity.User;
import by.radzivon.partshop.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Map;

@Slf4j
@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView addUser(User user, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb.isPresent()) {
            model.put("message", "User exists!");
            modelAndView.setViewName("registration");
        } else {
            // userRepository.save(user);
            log.info("save user with login" + user.getUsername());
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

}
