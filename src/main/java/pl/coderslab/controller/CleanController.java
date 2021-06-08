package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Clean;
import pl.coderslab.repository.CleanRepository;
import java.util.List;



@Controller
public class CleanController {

    private final CleanRepository cleanRepository;

    public CleanController(CleanRepository cleanRepository) {
        this.cleanRepository = cleanRepository;
    }


    @RequestMapping(value = {"/add/clean"})
    @ResponseBody
    public String home() {
        Clean clean = new Clean();
        clean.setId(1l);
        clean.setClean("Ironing");
        cleanRepository.saveClean(clean);
        return "clean: " + clean.getId();
    }


    @RequestMapping(value = "/clean/read/{id}")
    @ResponseBody
    public String readClean(@PathVariable long id) {
        Clean clean = cleanRepository.findById(id);
        return clean.toString();
    }

    @RequestMapping(value = "/clean/update/{id}/{name}")
    @ResponseBody
    public String updateClean(@PathVariable long id, @PathVariable String name) {
        Clean clean = cleanRepository.findById(id);
        clean.setClean(name);
        cleanRepository.updateClean(clean);
        return clean.toString();
    }

    @RequestMapping(value = "/clean/delete/{id}")
    @ResponseBody
    public String removeClean(@PathVariable long id) {
        Clean clean = cleanRepository.findById(id);
        return "Removed this clean";
    }

    @RequestMapping(value = {"/clean/all"})
    @ResponseBody
    public String cleanAll () {
        List<Clean> all = cleanRepository.findAll();
        return "cleans: " + all.size();
    }
}
