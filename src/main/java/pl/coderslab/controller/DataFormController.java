package pl.coderslab.controller;

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
public class DataFormController {

    private final UserRepository userRepository;
    private final DataRepository dataRepository;
    private final SpaceRepository spaceRepository;
    private final ServiceRepository serviceRepository;

    public DataFormController(UserRepository userRepository, DataRepository dataRepository,
                              SpaceRepository spaceRepository, ServiceRepository serviceRepository) {
        this.userRepository = userRepository;
        this.dataRepository = dataRepository;
        this.spaceRepository = spaceRepository;
        this.serviceRepository = serviceRepository;
    }

    @RequestMapping(value = "data/form")
    public String getDataForm(Model model) {
        Data data = new Data();
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

    @RequestMapping(value = "/data/delete/{id}")
    public String getDataFormById(@PathVariable Long id, Model model){
        Data data=dataRepository.findById(id);
        Hibernate.initialize(data.getDates());
        model.addAttribute("data", data);
        return "dataForm";
    }

    @RequestMapping(value = "/data/list", method = RequestMethod.POST)
    public String allDetas(Model model){
        List<Data> detas=dataRepository.findAll();
        model.addAttribute("detas", detas);
        return "detaList";
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