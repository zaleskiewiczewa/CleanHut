package pl.coderslab.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Space;
import pl.coderslab.repository.SpaceRepository;

public class SpaceConverter implements Converter<String, Space> {

    @Autowired
    private SpaceRepository repository;

    @Override
    public Space convert(String source) {
        return repository.findById(Long.parseLong(source));
    }
}