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
import pl.coderslab.repository.ActivitiesRepository;
import pl.coderslab.repository.DataRepository;
import pl.coderslab.repository.SpaceRepository;
import pl.coderslab.repository.UserRepository;
import javax.validation.Valid;
import java.util.List;

@Controller
public class SpaceFormController {

    private final UserRepository userRepository;
    private final DataRepository dataRepository;
    private final SpaceRepository spaceRepository;
    private final ActivitiesRepository activitiesRepository;

    public SpaceFormController(UserRepository userRepository, DataRepository dataRepository,
                              SpaceRepository spaceRepository, ActivitiesRepository activitiesRepository) {
        this.userRepository = userRepository;
        this.dataRepository = dataRepository;
        this.spaceRepository = spaceRepository;
        this.activitiesRepository = activitiesRepository;
    }

    @RequestMapping(value = "/space/form")
    public String getSpaceForm(Model model) {
        Space space = new Space();
        model.addAttribute("space", space);
        return "spaceForm";
    }

    @RequestMapping(value = "/space/remove/{id}")
    public String deleteById(@PathVariable Long id) {
        spaceRepository.removeSpace(id);
        return "redirect:/space/list";
    }

    @RequestMapping(value = "/space/form/{id}")
    public String getSpaceFormById(@PathVariable Long id, Model model) {
        Space space = spaceRepository.findById(id);
        Hibernate.initialize(space.getRooms());
        model.addAttribute("space", space);
        return "spaceForm";
    }

    @RequestMapping(value = "/space/form", method = RequestMethod.POST)
    public String postActivities(@ModelAttribute @Valid Space space, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "spaceForm";
        }
        spaceRepository.saveSpace(space);
        return "redirect:/space/list";
    }

    @RequestMapping(value = "/space/list", method = RequestMethod.GET)
    public String allSpace(Model model) {
        List<Space> spaceList = spaceRepository.findAll();
        model.addAttribute("space", spaceList);
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

    //   @ModelAttribute("activitys")
    //   public Collection<activity> publishers() {
    //     return (Collection<activity>) activityRepository.findAll();
    //   }

}
