package pl.coderslab.controller;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Room;
import pl.coderslab.repository.RoomRepository;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RoomFormController {

    private final RoomRepository roomRepository;

    public RoomFormController(RoomRepository roomRepository) {

        this.roomRepository = roomRepository;
    }

    @RequestMapping(value = "/room/form")
    public String getRoomForm(Model model) {
        Room room = new Room();
        model.addAttribute("room", room);
        return "roomForm";
    }

    @RequestMapping(value = "/room/remove/{id}")
    public String deleteById(@PathVariable Long id) {
        roomRepository.removeRoom(id);
        return "redirect:/room/list";
    }

//    @RequestMapping(value = "/room/form/{id}")
//  public String getRoomFormById(@PathVariable Long id, Model model) {
//      Room room = roomRepository.findById(id);
//      Hibernate.initialize((room.getRoom()));
//        model.addAttribute("room", room);
//        return "roomForm";
//    }

    @RequestMapping(value = "/room/form", method = RequestMethod.POST)
    public String postRoom(@ModelAttribute @Valid Room room, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "roomForm";
        }
        roomRepository.saveRoom(room);
        return "redirect:/room/list";
    }

    @RequestMapping(value = "/room/list", method = RequestMethod.GET)
    public String allRoom(Model model) {
        List<Room> roomList = roomRepository.findAll();
        model.addAttribute("room", roomList);
        return "roomList";
    }

}
