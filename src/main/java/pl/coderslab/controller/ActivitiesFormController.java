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

    @RequestMapping(value = "/activities/remove/{id}")
    public String deleteById(@PathVariable Long id) {
        activitiesRepository.removeActivities(id);
        return "redirect:/activities/list";
    }

    @RequestMapping(value = "/activities/form/{id}")
    public String getActivitiesFormById(@PathVariable Long id, Model model) {
       Activities activities = activitiesRepository.findById(id);
        Hibernate.initialize(activities.getActivities());
        model.addAttribute("activities", activities);
        return "activitiesForm";
    }

    @RequestMapping(value = "/activities/form", method = RequestMethod.POST)
    public String postActivities(@ModelAttribute @Valid Activities activities, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "activitiesForm";
        }
        activitiesRepository.saveActivities(activities);
        return "redirect:/activities/list";
    }

    @RequestMapping(value = "/activities/list", method = RequestMethod.GET)
    public String allActivities(Model model) {
        List<Activities> activitiesList = activitiesRepository.findAll();
        model.addAttribute("activities", activitiesList);
        return "activitiesList";
    }


    @ModelAttribute("users")
    public Collection<User> users() {
        return this.userRepository.findAll();
    }




}