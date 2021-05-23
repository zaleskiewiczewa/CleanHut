package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
        service.setService("Vacuum");
        serviceRepository.saveService(service);
        return "service: " + service.getId();
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



