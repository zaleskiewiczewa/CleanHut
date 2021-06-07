package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import java.util.List;

@Transactional
@Controller
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
        user.setEmail("zaleskiewicz.ewa@onet.pl");
        user.setPassword("skillet15");
        userRepository.saveUser(user);
        return "User: " + user.getId();
    }


    @RequestMapping(value = "/user/read/{id}")
    @ResponseBody
    public String readUser(@PathVariable long id) {
        User user = userRepository.findById(id);
        return user.toString();
    }

    @RequestMapping(value = "/user/update/{id}/{name}")
    @ResponseBody
    public String updateUser(@PathVariable long id, @PathVariable String name) {
        User user = userRepository.findById(id);
        user.setName(name);
        userRepository.updateUser(user);
        return user.toString();
    }

    @RequestMapping(value = "/user/delete/{id}")
    @ResponseBody
    public String removeUser(@PathVariable long id) {
        User user = userRepository.findById(id);
        return "Removed this user";
    }

    @RequestMapping(value = {"/user/all"})
    @ResponseBody
    public String bookAll () {
        List<User> all = userRepository.findAll();
        return "Users: " + all.size();
    }
}




