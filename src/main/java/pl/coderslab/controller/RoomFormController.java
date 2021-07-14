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
import pl.coderslab.entity.User;
import pl.coderslab.repository.CleanRepository;
import pl.coderslab.repository.RoomRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.repository.WeekRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RoomFormController {
    private final RoomRepository roomRepository;
    private final CleanRepository cleanRepository;
    private final WeekRepository weekRepository;

    public RoomFormController(RoomRepository roomRepository, CleanRepository cleanRepository, WeekRepository weekRepository) {
        this.roomRepository = roomRepository;
        this.cleanRepository = cleanRepository;
        this.weekRepository = weekRepository;
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
//   public String getroomFormById(@PathVariable Long id, Model model) {
//       room room = roomRepository.findById(id);
//       Hibernate.initialize(room.g());
//     model.addAttribute("room", room);
//        return "roomForm";
// }

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
