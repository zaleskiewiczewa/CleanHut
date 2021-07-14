package pl.coderslab.controller;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Clean;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CleanRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.repository.WeekRepository;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CleanFormController {

    private final UserRepository userRepository;
    private final CleanRepository cleanRepository;
    private final WeekRepository weekRepository;

    public CleanFormController(UserRepository userRepository, CleanRepository cleanRepository, WeekRepository weekRepository) {
        this.userRepository = userRepository;
        this.cleanRepository = cleanRepository;
        this.weekRepository = weekRepository;
    }

    @RequestMapping(value = "/clean/form")
    public String getCleanForm(Model model) {
        Clean clean = new Clean();
        model.addAttribute("clean", clean);
        return "cleanForm";
    }

    @RequestMapping(value = "/clean/remove/{id}")
    public String deleteById(@PathVariable Long id) {
        cleanRepository.removeClean(id);
        return "redirect:/clean/list";
    }

//    @RequestMapping(value = "/clean/form/{id}")
//   public String getcleanFormById(@PathVariable Long id, Model model) {
//       clean clean = cleanRepository.findById(id);
//       Hibernate.initialize(clean.g());
//     model.addAttribute("clean", clean);
//        return "cleanForm";
// }

    @RequestMapping(value = "/clean/form", method = RequestMethod.POST)
    public String postClean(@ModelAttribute @Valid Clean clean, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cleanForm";
        }
        cleanRepository.saveClean(clean);
        return "redirect:/clean/list";
    }

    @RequestMapping(value = "/clean/list", method = RequestMethod.GET)
    public String allClean(Model model) {
        List<Clean> cleanList = cleanRepository.findAll();
        model.addAttribute("clean", cleanList);
        return "cleanList";
    }


}


