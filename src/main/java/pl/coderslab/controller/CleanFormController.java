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
import pl.coderslab.repository.CleanRepository;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CleanFormController {


    private final CleanRepository cleanRepository;

    public CleanFormController(CleanRepository cleanRepository) {
        this.cleanRepository = cleanRepository;

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

    @RequestMapping(value = "/clean/form/{id}")
    public String getCleanFormById(@PathVariable Long id, Model model) {
        Clean clean = cleanRepository.findById(id);
        Hibernate.initialize((clean.getClean()));
        model.addAttribute("clean", clean);
        return "cleanForm";
    }

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


