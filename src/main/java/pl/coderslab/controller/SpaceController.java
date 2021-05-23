package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Space;
import pl.coderslab.repository.SpaceRepository;
import javax.validation.Valid;

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
        space.setSpace("Room 1");
        spaceRepository.saveSpace(space);
        return "space: " + space.getId();
    }

    @RequestMapping(value = "space/form")
    public String getspaceForm(Model model) {
        Space space = new Space();
        model.addAttribute("space", space);
        return "spaceForm";
    }

    @RequestMapping(value = "/space/form", method = RequestMethod.POST)
    public String postspace(@ModelAttribute @Valid Space space, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

        }
        return "spaceForm";
    }
}



