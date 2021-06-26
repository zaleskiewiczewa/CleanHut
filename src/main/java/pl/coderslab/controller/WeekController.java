package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Week;
import pl.coderslab.repository.WeekRepository;


import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Controller
public class WeekController {
    private final WeekRepository weekRepository;

    public WeekController(WeekRepository weekRepository) {
        this.weekRepository = weekRepository;
    }


    @RequestMapping(value = {"/add/week"})
    public String home() {
        Week week = new Week();
        week.setId(1l);
        weekRepository.saveWeek(week);
        return "week: " + week.getId();
    }

    @RequestMapping(value = "/week/read/{id}")
    public String readWeek(@PathVariable long id) {
        Week week = weekRepository.findById(id);
        return week.toString();
    }

    @RequestMapping(value = "/week/update/{id}/{name}")
    public String updateWeek(@PathVariable long id, @PathVariable String week1) {
        Week week = weekRepository.findById(id);
        week.setWeek(week1);
        weekRepository.updateWeek(week);
        return week.toString();
    }

    @RequestMapping(value = "/week/delete/{id}")
    public String removeWeek(@PathVariable long id) {
        Week week = weekRepository.findById(id);
        return "Removed this week";
    }

    @RequestMapping(value = {"/week/all"})
    public String weekAll () {
        List<Week> all = weekRepository.findAll();
        return "weeks: " + all.size();
    } 
    
    
}
