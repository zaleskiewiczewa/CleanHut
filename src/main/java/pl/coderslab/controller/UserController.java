package pl.coderslab.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;

public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = {"/adduser"})
    @ResponseBody
    public String home() {
        User user = new User();
        user.setId(1l);
        user.setName("Ewa");
        user.getEmail("zaleskiewicz.ewa@onet.pl");
        user.setPassword("skillet15");
        userRepository.save(user);
        return "user: " + user.getId();
    }

    @RequestMapping(value = "user/form")
    public String getuserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userForm";
    }

    @RequestMapping(value = "/user/form", method = RequestMethod.POST)
    public String postuser(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

        }
        return "userForm";
    }
}



