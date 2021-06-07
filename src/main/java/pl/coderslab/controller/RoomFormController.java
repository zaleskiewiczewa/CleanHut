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
import pl.coderslab.repository.CleaningRepository;
import pl.coderslab.repository.RoomRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.repository.WeekRepository;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RoomFormController {

    private final UserRepository userRepository;
    private final WeekRepository weekRepository;
    private final RoomRepository roomRepository;
    private final CleaningRepository cleaningRepository;

    public RoomFormController(UserRepository userRepository, WeekRepository weekRepository,
                              RoomRepository roomRepository, CleaningRepository cleaningRepository) {
        this.userRepository = userRepository;
        this.weekRepository = weekRepository;
        this.roomRepository = roomRepository;
        this.cleaningRepository = cleaningRepository;
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

    @RequestMapping(value = "/room/form/{id}")
  public String getroomFormById(@PathVariable Long id, Model model) {
      Room room = roomRepository.findById(id);
      Hibernate.initialize((room.getRoom()));
        model.addAttribute("room", room);
        return "roomForm";
    }

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
