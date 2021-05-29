package pl.coderslab.controller;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Activities;
import pl.coderslab.repository.ActivitiesRepository;
import pl.coderslab.repository.DataRepository;
import pl.coderslab.repository.SpaceRepository;
import pl.coderslab.repository.UserRepository;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ActivitiesFormController {
    private final UserRepository userRepository;
    private final DataRepository dataRepository;
    private final SpaceRepository spaceRepository;
    private final ActivitiesRepository activitiesRepository;

    public ActivitiesFormController(UserRepository userRepository, DataRepository dataRepository,
                              SpaceRepository spaceRepository, ActivitiesRepository activitiesRepository) {
        this.userRepository = userRepository;
        this.dataRepository = dataRepository;
        this.spaceRepository = spaceRepository;
        this.activitiesRepository = activitiesRepository;
    }

    @RequestMapping(value = "/activities/form")
    public String getActivitiesForm(Model model) {
        Activities activities = new Activities();
        model.addAttribute("activities", activities);
        return "activitiesForm";
    }

    @RequestMapping(value = "/activities/form", method = RequestMethod.POST)
    public String postActivities(@Valid Activities activities, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "activitiesForm";
        }
        activitiesRepository.saveActivities(activities);
        return "redirect:/activities/list";
    }

    @RequestMapping(value ="/activities/remove/{id}")
    public String getActivitiesFormById(@PathVariable Long id, Model model){
        Activities activities=activitiesRepository.findById(id);
        Hibernate.initialize(activities.getActivitiess());
        model.addAttribute("activities", activities);
        return "activitiesForm";
    }

    @RequestMapping(value = "/activities/list", method = RequestMethod.GET)
    public String allActivities(Model model){
        List<Activities> activities=activitiesRepository.findAll();
        model.addAttribute("activities", activities);
        return "activitiesList";
    }

    //  @ModelAttribute("dates")
    //   public Collection<activities> publishers() {
    //      return (Collection<activities>) activitiesRepository.findAll();
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