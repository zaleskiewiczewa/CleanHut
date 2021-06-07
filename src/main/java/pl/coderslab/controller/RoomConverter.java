package pl.coderslab.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Room;
import pl.coderslab.repository.RoomRepository;

public class RoomConverter implements Converter<String, Room> {

    @Autowired
    private RoomRepository repository;

    @Override
    public Room convert(String source) {
        return repository.findById(Long.parseLong(source));
    }
}