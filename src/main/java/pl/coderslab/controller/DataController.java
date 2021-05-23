package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Data;
import pl.coderslab.repository.DataRepository;
import javax.validation.Valid;

@Controller
public class DataController {

    private final DataRepository dataRepository;

    public DataController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @RequestMapping(value = {"/adddata"})
    @ResponseBody
    public String home() {
        Data data = new Data();
        data.setId(1l);
       // data.setData(08,12,2021);
        dataRepository.saveData(data);
        return "data: " + data.getId();
    }

    @RequestMapping(value = "/data/form")
    public String getdataForm(Model model) {
        Data data = new Data();
        model.addAttribute("data", data);
        return "dataForm";
    }

    @RequestMapping(value = "/data/form", method = RequestMethod.POST)
    public String postdata(@ModelAttribute @Valid Data data, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

        }
        return "dataForm";
    }
}
