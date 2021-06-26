package pl.coderslab.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Week;
import pl.coderslab.repository.WeekRepository;

public class WeekConverter implements Converter<String, Week> {

    @Autowired
    private WeekRepository repository;

    @Override
    public Week convert(String source) {
        return repository.findById(Long.parseLong(source));
    }
}

