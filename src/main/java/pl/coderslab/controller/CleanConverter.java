package pl.coderslab.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Clean;
import pl.coderslab.repository.CleanRepository;


public class CleanConverter implements Converter<String, Clean> {

    @Autowired
    private CleanRepository repository;

    @Override
    public Clean convert(String source) {
        return repository.findById(Long.parseLong(source));
    }
}