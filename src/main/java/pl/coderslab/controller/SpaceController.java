package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Space;
import pl.coderslab.entity.User;
import pl.coderslab.repository.SpaceRepository;
import javax.validation.Valid;
import java.util.List;

@Controller
public class SpaceController {

    private final SpaceRepository spaceRepository;

    public SpaceController(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    @RequestMapping(value = {"/addspace"})
    @ResponseBody
    public String home() {
        Space space = new Space();
        space.setId(1l);
        space.setRooms("Room 1");
        spaceRepository.saveSpace(space);
        return "space: " + space.getId();
    }

    @RequestMapping (value = "/space/read/{id}")
    @ResponseBody
    public String readSpace(@PathVariable long id){
        Space space= spaceRepository.findById(id);
        return space.toString();
    }

    @RequestMapping (value = "/space/update/{id}/{room}")
    @ResponseBody
    public String updateSpace(@PathVariable  long id, @PathVariable String room){
        Space space =spaceRepository.findById(id);
        space.setRooms(room);
        spaceRepository.updateSpace(space);
        return space.toString();
    }

    @RequestMapping (value = "/space/delete/{id}")
    @ResponseBody
    public String removeSpace(@PathVariable long id){
        Space space = spaceRepository.findById(id);
        return "Removed this space";
    }


    @RequestMapping(value = {"/space/all"})
    @ResponseBody
    public String spaceAll () {
        List<Space> all = spaceRepository.findAll();
        return "Spaces: " + all.size();
    }

}



