package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Data;
import pl.coderslab.entity.User;
import pl.coderslab.repository.DataRepository;
import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping (value = "/data/read/{id}")
    @ResponseBody
    public String readData(@PathVariable long id){
        Data data= dataRepository.findById(id);
        return data.toString();
    }

    @RequestMapping (value = "/data/update/{id}/{dates}")
    @ResponseBody
    public String updateData(@PathVariable  long id, @PathVariable int dates){
        Data data =dataRepository.findById(id);
        data.setDates(dates);
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
