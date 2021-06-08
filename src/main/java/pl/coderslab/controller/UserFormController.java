package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CleanRepository;
import pl.coderslab.repository.RoomRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.repository.WeekRepository;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserFormController {

    private final UserRepository userRepository;
    private final WeekRepository weekRepository;
    private final RoomRepository roomRepository;
    private final CleanRepository cleanRepository;

    public UserFormController(UserRepository userRepository, WeekRepository weekRepository,
                              RoomRepository roomRepository, CleanRepository cleanRepository) {
        this.userRepository = userRepository;
        this.weekRepository = weekRepository;
        this.roomRepository = roomRepository;
        this.cleanRepository = cleanRepository;
    }

    @RequestMapping(value = "/user/form")
    public String getUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userForm";
    }

    @RequestMapping(value = "/user/remove/{id}")
    public String deleteById(@PathVariable Long id) {
        userRepository.removeUser(id);
        return "redirect:/user/list";
    }

//    @RequestMapping(value = "/user/form/{id}")
//   public String getUserFormById(@PathVariable Long id, Model model) {
//       User user = userRepository.findById(id);
//       Hibernate.initialize(user.g());
//     model.addAttribute("user", user);
//        return "userForm";
// }

    @RequestMapping(value = "/user/form", method = RequestMethod.POST)
    public String postUser(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        userRepository.saveUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String allUser(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("user", userList);
        return "userList";
    }

}
