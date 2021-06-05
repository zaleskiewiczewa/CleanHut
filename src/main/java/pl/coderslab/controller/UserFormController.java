package pl.coderslab.controller;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Activities;
import pl.coderslab.entity.Space;
import pl.coderslab.entity.User;
import pl.coderslab.repository.ActivitiesRepository;
import pl.coderslab.repository.DataRepository;
import pl.coderslab.repository.SpaceRepository;
import pl.coderslab.repository.UserRepository;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class UserFormController {

    private final UserRepository userRepository;
    private final DataRepository dataRepository;
    private final SpaceRepository spaceRepository;
    private final ActivitiesRepository activitiesRepository;

    public UserFormController(UserRepository userRepository, DataRepository dataRepository,
                              SpaceRepository spaceRepository, ActivitiesRepository activitiesRepository) {
        this.userRepository = userRepository;
        this.dataRepository = dataRepository;
        this.spaceRepository = spaceRepository;
        this.activitiesRepository = activitiesRepository;
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

    @RequestMapping(value = "/user/form/{id}")
    public String getUserFormById(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id);
        Hibernate.initialize(user.getActivities());
        model.addAttribute("user", user);
        return "userForm";
    }

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

    @ModelAttribute("activities")
    public Collection<Activities> activities() {
        return this.activitiesRepository.findAll();
    }

  //  @ModelAttribute("spaces")
    //public Collection<Space> publishers() {
     //   return (Collection<Space>) spaceRepository.findAll();
   // }

 //   @ModelAttribute("services")
 //   public Collection<Service> publishers() {
   //     return (Collection<Service>) serviceRepository.findAll();
 //   }

}
