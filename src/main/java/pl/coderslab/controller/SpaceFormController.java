package pl.coderslab.controller;
import org.hibernate.Hibernate;
import org.hibernate.Hibernate;
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
public class SpaceFormController {

    private final UserRepository userRepository;
    private final DataRepository dataRepository;
    private final SpaceRepository spaceRepository;
    private final ServiceRepository serviceRepository;

    public SpaceFormController(UserRepository userRepository, DataRepository dataRepository,
                              SpaceRepository spaceRepository, ServiceRepository serviceRepository) {
        this.userRepository = userRepository;
        this.dataRepository = dataRepository;
        this.spaceRepository = spaceRepository;
        this.serviceRepository = serviceRepository;
    }

    @RequestMapping(value = "space/form")
    public String getSpaceForm(Model model) {
        Space space = new Space();
        model.addAttribute("space", space);
        return "spaceForm";
    }

    @RequestMapping(value = "/space/form", method = RequestMethod.POST)
    public String postSpace(@ModelAttribute @Valid Space space, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "spaceForm";
        }
        spaceRepository.saveSpace(space);
        return "redirect:/space/list";
    }

    @RequestMapping(value = "/space/delete/{id}")
    public String getSpaceFormById(@PathVariable Long id, Model model){
        Space space=spaceRepository.findById(id);
        Hibernate.initialize(space.getRooms());
        model.addAttribute("space", space);
        return "spaceForm";
    }

    @RequestMapping(value = "/space/list", method = RequestMethod.POST)
    public String allSpaces(Model model){
        List<Space> spaces=spaceRepository.findAll();
        model.addAttribute("spaces", spaces);
        return "spaceList";
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
