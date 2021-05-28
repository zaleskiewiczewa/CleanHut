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
public class ServiceFormController {

    private final UserRepository userRepository;
    private final DataRepository dataRepository;
    private final SpaceRepository spaceRepository;
    private final ServiceRepository serviceRepository;

    public ServiceFormController(UserRepository userRepository, DataRepository dataRepository,
                              SpaceRepository spaceRepository, ServiceRepository serviceRepository) {
        this.userRepository = userRepository;
        this.dataRepository = dataRepository;
        this.spaceRepository = spaceRepository;
        this.serviceRepository = serviceRepository;
    }

    @RequestMapping(value = "service/form")
    public String getServiceForm(Model model) {
        Service service = new Service();
        model.addAttribute("service", service);
        return "serviceForm";
    }

    @RequestMapping(value = "/serviceform", method = RequestMethod.POST)
    public String postService(@ModelAttribute @Valid Service service, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "serviceForm";
        }
        serviceRepository.saveService(service);
        return "redirect:/service/list";
    }

    @RequestMapping(value = "/service/remove/{id}")
    public String getServiceFormById(@PathVariable Long id, Model model){
        Service service=serviceRepository.findById(id);
        Hibernate.initialize(service.getServices());
        model.addAttribute("service", service);
        return "serviceForm";
    }

    @RequestMapping(value = "/service/list", method = RequestMethod.POST)
    public String allServices(Model model){
        List<Service> services=serviceRepository.findAll();
        model.addAttribute("services", services);
        return "serviceList";
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
