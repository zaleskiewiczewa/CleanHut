package pl.coderslab.controller;
import org.hibernate.Hibernate;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Data;
import pl.coderslab.entity.Service;
import pl.coderslab.entity.Space;
import pl.coderslab.entity.User;
import pl.coderslab.repository.DataRepository;
import pl.coderslab.repository.ServiceRepository;
import pl.coderslab.repository.SpaceRepository;
import pl.coderslab.repository.UserRepository;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserFormController {

    private final UserRepository userRepository;
    private final DataRepository dataRepository;
    private final SpaceRepository spaceRepository;
    private final ServiceRepository serviceRepository;

    public UserFormController(UserRepository userRepository, DataRepository dataRepository,
                              SpaceRepository spaceRepository, ServiceRepository serviceRepository) {
        this.userRepository = userRepository;
        this.dataRepository = dataRepository;
        this.spaceRepository = spaceRepository;
        this.serviceRepository = serviceRepository;
    }

    @RequestMapping(value = "user/form")
    public String getUserForm(Model model) {
        User user = new User();
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

    @RequestMapping(value = "/user/delete/{id}")
    public String getUserFormById(@PathVariable Long id, Model model){
        User user=userRepository.findById(id);
        Hibernate.initialize(user.getUsers());
        model.addAttribute("user", user);
        return "userForm";
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    public String allUsers(Model model){
        List<User> users=userRepository.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

  //  @ModelAttribute("dates")
 //   public Collection<Data> publishers() {
  //      return (Collection<Data>) dataRepository.findAll();
  //  }

  //  @ModelAttribute("spaces")
    //public Collection<Space> publishers() {
     //   return (Collection<Space>) spaceRepository.findAll();
   // }

 //   @ModelAttribute("services")
 //   public Collection<Service> publishers() {
   //     return (Collection<Service>) serviceRepository.findAll();
 //   }

}
