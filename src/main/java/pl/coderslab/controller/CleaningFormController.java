package pl.coderslab.controller;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Cleaning;
import pl.coderslab.repository.CleaningRepository;
import pl.coderslab.repository.RoomRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.repository.WeekRepository;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CleaningFormController {

    private final UserRepository userRepository;
    private final WeekRepository weekRepository;
    private final RoomRepository roomRepository;
    private final CleaningRepository cleaningRepository;

    public CleaningFormController(UserRepository userRepository, WeekRepository weekRepository,
                              RoomRepository roomRepository, CleaningRepository cleaningRepository) {
        this.userRepository = userRepository;
        this.weekRepository = weekRepository;
        this.cleaningRepository = cleaningRepository;
        this.roomRepository = roomRepository;
    }

    @RequestMapping(value = "/cleaning/form")
    public String getCleaningForm(Model model) {
        Cleaning cleaning = new Cleaning();
        model.addAttribute("cleaning", cleaning);
        return "cleaningForm";
    }

    @RequestMapping(value = "/cleaning/remove/{id}")
    public String deleteById(@PathVariable Long id) {
        cleaningRepository.removeCleaning(id);
        return "redirect:/cleaning/list";
    }

    @RequestMapping(value = "/cleaning/form/{id}")
    public String getCleaningFormById(@PathVariable Long id, Model model) {
        Cleaning cleaning = cleaningRepository.findById(id);
        Hibernate.initialize((cleaning.getCleaning()));
        model.addAttribute("cleaning", cleaning);
        return "cleaningForm";
    }

    @RequestMapping(value = "/cleaning/form", method = RequestMethod.POST)
    public String postCleaning(@ModelAttribute @Valid Cleaning cleaning, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cleaningForm";
        }
        cleaningRepository.saveCleaning(cleaning);
        return "redirect:/cleaning/list";
    }

    @RequestMapping(value = "/cleaning/list", method = RequestMethod.GET)
    public String allCleaning(Model model) {
        List<Cleaning> cleaningList = cleaningRepository.findAll();
        model.addAttribute("cleaning", cleaningList);
        return "roomList";
    }

}


