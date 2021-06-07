package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Room;
import pl.coderslab.repository.RoomRepository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Controller
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @RequestMapping(value = {"/add/room"})
    @ResponseBody
    public String home() {
        Room room = new Room();
        room.setId(1l);
        room.setRoom("Room 1");
        roomRepository.saveRoom(room);
        return "room: " + room.getId();
    }

    @RequestMapping (value = "/room/read/{id}")
    @ResponseBody
    public String readRoom(@PathVariable long id){
        Room room= roomRepository.findById(id);
        return room.toString();
    }

    @RequestMapping (value = "/room/update/{id}/{room}")
    @ResponseBody
    public String updateRoom(@PathVariable  long id, @PathVariable String room){
        Room room1 =roomRepository.findById(id);
        room1.setRoom("Room1");
        roomRepository.updateRoom(room1);
        return room.toString();
    }

    @RequestMapping (value = "/room/delete/{id}")
    @ResponseBody
    public String removeRoom(@PathVariable long id){
        Room room = roomRepository.findById(id);
        return "Removed this room";
    }


    @RequestMapping(value = {"/room/all"})
    @ResponseBody
    public String roomAll () {
        List<Room> all = roomRepository.findAll();
        return "rooms: " + all.size();
    }

}



