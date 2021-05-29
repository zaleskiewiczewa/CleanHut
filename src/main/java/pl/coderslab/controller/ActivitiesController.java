package pl.coderslab.controller;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Activities;
import pl.coderslab.repository.ActivitiesRepository;
import java.util.List;

@Controller
public class ActivitiesController {

    private final ActivitiesRepository activitiesRepository;

    public ActivitiesController(ActivitiesRepository activitiesRepository) {
        this.activitiesRepository = activitiesRepository;
    }

    @RequestMapping(value = {"/addactivities"})
    @ResponseBody
    public String home() {
        Activities activities = new Activities();
        activities.setId(1l);
        // activities.setactivities(08,12,2021);
        activitiesRepository.saveActivities(activities);
        return "activities: " + activities.getId();
    }

    @RequestMapping (value = "/activities/read/{id}")
    @ResponseBody
    public String readActivities(@PathVariable long id){
        Activities activities= activitiesRepository.findById(id);
        return activities.toString();
    }

    @RequestMapping (value = "/activities/update/{id}/{activities}")
    @ResponseBody
    public String updateActivities(@PathVariable  long id, @PathVariable String actvities){
        Activities activities =activitiesRepository.findById(id);
        activities.setActivitiess(actvities);
        activitiesRepository.updateActivities(activities);
        return activities.toString();
    }

    @RequestMapping (value = "/activities/delete/{id}")
    @ResponseBody
    public String removeActivities(@PathVariable long id){
        Activities activities = activitiesRepository.findById(id);
        return "Removed this activities";
    }

    @RequestMapping(value = {"/activities/all"})
    @ResponseBody
    public String activitiesAll () {
        List<Activities> all = activitiesRepository.findAll();
        return "activities: " + all.size();
    }

}
