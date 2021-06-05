package pl.coderslab.controller;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Data;
import pl.coderslab.entity.Space;
import pl.coderslab.repository.ActivitiesRepository;
import pl.coderslab.repository.DataRepository;
import pl.coderslab.repository.SpaceRepository;
import pl.coderslab.repository.UserRepository;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class DataFormController {

    private final UserRepository userRepository;
    private final DataRepository dataRepository;
    private final SpaceRepository spaceRepository;
    private final ActivitiesRepository activitiesRepository;

    public DataFormController(UserRepository userRepository, DataRepository dataRepository,
                              SpaceRepository spaceRepository, ActivitiesRepository activitiesRepository) {
        this.userRepository = userRepository;
        this.dataRepository = dataRepository;
        this.spaceRepository = spaceRepository;
        this.activitiesRepository = activitiesRepository;
    }

    @RequestMapping(value = "/data/form")
    public String getDataForm(Model model) {
       Data data = new Data();
        model.addAttribute("data", data);
        return "dataForm";
    }

  //  @RequestMapping(value = "/data/remove/{id}")
    //public String deleteById(@PathVariable Long id) {
    //   DataRepository.
      //  return "redirect:/data/list";
    //}

    @RequestMapping(value = "/data/form/{id}")
    public String getDataFormById(@PathVariable Long id, Model model) {
        Data data = dataRepository.findById(id);
        Hibernate.initialize(data.getDates());
        model.addAttribute("data", data);
        return "dataForm";
    }

    @RequestMapping(value = "/data/form", method = RequestMethod.POST)
    public String postData(@ModelAttribute @Valid Data data, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "dataForm";
        }
        dataRepository.saveData(data);
        return "redirect:/data/list";
    }

    @RequestMapping(value = "/data/list", method = RequestMethod.GET)
    public String allData(Model model) {
        List<Data> dataList = dataRepository.findAll();
        model.addAttribute("data", dataList);
        return "dataList";
    }

   @ModelAttribute("rooms")
    public Collection<Space> rooms() {
      return this.spaceRepository.findAll();
     }

}
