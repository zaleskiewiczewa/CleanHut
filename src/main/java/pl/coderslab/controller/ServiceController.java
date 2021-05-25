package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Service;
import pl.coderslab.repository.ServiceRepository;
import javax.validation.Valid;

@Controller
public class ServiceController {

    private final ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @RequestMapping(value = {"/addservice"})
    @ResponseBody
    public String home() {
        Service service = new Service();
        service.setId(1l);
        service.setServices("Vacuum");
        serviceRepository.saveService(service);
        return "service: " + service.getId();
    }

    @RequestMapping (value = "/service/read/{id}")
    @ResponseBody
    public String readService(@PathVariable long id){
        Service service= serviceRepository.findById(id);
        return service.toString();
    }

    @RequestMapping (value = "/service/update/{id}/{services}")
    @ResponseBody
    public String updateService(@PathVariable  long id, @PathVariable String services){
        Service service =serviceRepository.findById(id);
        service.setServices(services);
        serviceRepository.updateService(service);
        return service.toString();
    }

    @RequestMapping (value = "/service/delete/{id}")
    @ResponseBody
    public String removeservice(@PathVariable long id){
        Service service = serviceRepository.findById(id);
        return "Removed this service";
    }

    @RequestMapping(value = "service/form")
    public String getserviceForm(Model model) {
        Service service = new Service();
        model.addAttribute("service", service);
        return "serviceForm";
    }

    @RequestMapping(value = "/service/form", method = RequestMethod.POST)
    public String postservice(@ModelAttribute @Valid Service service, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        }
        return "serviceForm";
    }
}



