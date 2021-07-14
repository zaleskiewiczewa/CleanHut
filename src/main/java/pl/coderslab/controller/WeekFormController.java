package pl.coderslab.controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.User;
import pl.coderslab.entity.Week;
import pl.coderslab.repository.CleanRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.repository.WeekRepository;
import javax.validation.Valid;
import java.util.List;

public class WeekFormController {


    private final UserRepository userRepository;
    private final CleanRepository cleanRepository;
    private final WeekRepository weekRepository;

    public WeekFormController(UserRepository userRepository, CleanRepository cleanRepository, WeekRepository weekRepository) {
        this.userRepository = userRepository;
        this.cleanRepository = cleanRepository;
        this.weekRepository = weekRepository;
    }

    @RequestMapping(value = "/week/form")
    public String getWeekForm(Model model) {
        Week week = new Week();
        model.addAttribute("week", week);
        return "week";
    }

    @RequestMapping(value = "/week/remove/{id}")
    public String deleteById(@PathVariable Long id) {
        weekRepository.removeWeek(id);
        return "redirect:/week/list";
    }

//    @RequestMapping(value = "/week/form/{id}")
//   public String getweekFormById(@PathVariable Long id, Model model) {
//       week week = weekRepository.findById(id);
//       Hibernate.initialize(week.g());
//     model.addAttribute("week", week);
//        return "weekForm";
// }

    @RequestMapping(value = "/week/form", method = RequestMethod.POST)
    public String postWeek(@ModelAttribute @Valid Week week, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "week";
        }
        weekRepository.saveWeek(week);
        return "redirect:/week/list";
    }

    @RequestMapping(value = "/week/list", method = RequestMethod.GET)
    public String allWeek(Model model) {
        List<Week> weekList = weekRepository.findAll();
        model.addAttribute("week", weekList);
        return "weekList";
    }

}
