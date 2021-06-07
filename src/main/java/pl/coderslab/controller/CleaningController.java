package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Cleaning;
import pl.coderslab.repository.CleaningRepository;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Controller
public class CleaningController {

    private final CleaningRepository cleaningRepository;

    public CleaningController(CleaningRepository cleaningRepository) {
        this.cleaningRepository = cleaningRepository;
    }


    @RequestMapping(value = {"/add/cleaning"})
    @ResponseBody
    public String home() {
        Cleaning cleaning = new Cleaning();
        cleaning.setId(1l);
        cleaning.setCleaning("Ironing");
        cleaningRepository.saveCleaning(cleaning);
        return "cleaning: " + cleaning.getId();
    }


    @RequestMapping(value = "/cleaning/read/{id}")
    @ResponseBody
    public String readCleaning(@PathVariable long id) {
        Cleaning cleaning = cleaningRepository.findById(id);
        return cleaning.toString();
    }

    @RequestMapping(value = "/cleaning/update/{id}/{name}")
    @ResponseBody
    public String updateCleaning(@PathVariable long id, @PathVariable String name) {
        Cleaning cleaning = cleaningRepository.findById(id);
        cleaning.setCleaning(name);
        cleaningRepository.updateCleaning(cleaning);
        return cleaning.toString();
    }

    @RequestMapping(value = "/cleaning/delete/{id}")
    @ResponseBody
    public String removeCleaning(@PathVariable long id) {
        Cleaning cleaning = cleaningRepository.findById(id);
        return "Removed this cleaning";
    }

    @RequestMapping(value = {"/cleaning/all"})
    @ResponseBody
    public String cleaningAll () {
        List<Cleaning> all = cleaningRepository.findAll();
        return "cleanings: " + all.size();
    }
}
