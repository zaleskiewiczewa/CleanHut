package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Data;
import pl.coderslab.repository.DataRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
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
        data.setDates("Week 24");
        dataRepository.saveData(data);
        return "data: " + data.getId();
    }

    @RequestMapping (value = "/data/read/{id}")
    @ResponseBody
    public String readData(@PathVariable long id){
        Data data= dataRepository.findById(id);
        return data.toString();
    }

    @RequestMapping (value = "/data/update/{id}/{dates}")
    @ResponseBody
    public String updateData(@PathVariable long id, @PathVariable LocalDate dates){
        Data data =dataRepository.findById(id);
        dataRepository.updateData(data);
        return data.toString();
    }

    @RequestMapping (value = "/data/delete/{id}")
    @ResponseBody
    public String removeData(@PathVariable long id){
        Data data = dataRepository.findById(id);
        return "Removed this data";
    }

    @RequestMapping(value = {"/data/all"})
    @ResponseBody
    public String dataAll () {
        List<Data> all = dataRepository.findAll();
        return "Data: " + all.size();
    }

}
