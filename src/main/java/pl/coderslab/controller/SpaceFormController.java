package pl.coderslab.controller;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Space;
import pl.coderslab.repository.CleaningRepository;
import pl.coderslab.repository.SpaceRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.repository.WeekRepository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class SpaceFormController {

    private final UserRepository userRepository;
    private final WeekRepository weekRepository;
    private final SpaceRepository spaceRepository;
    private final CleaningRepository cleaningRepository;

    public SpaceFormController(UserRepository userRepository, WeekRepository weekRepository,
                              SpaceRepository spaceRepository, CleaningRepository cleaningRepository) {
        this.userRepository = userRepository;
        this.weekRepository = weekRepository;
        this.spaceRepository = spaceRepository;
        this.cleaningRepository = cleaningRepository;
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

}
