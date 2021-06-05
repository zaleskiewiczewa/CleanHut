package pl.coderslab.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Activities;
import pl.coderslab.entity.Space;
import pl.coderslab.repository.ActivitiesRepository;
import pl.coderslab.repository.SpaceRepository;

public class  ActivitiesConverter implements Converter<String, Activities> {

    @Autowired
    private ActivitiesRepository repository;

    @Override
    public Activities convert(String source) {
        return repository.findById(Long.parseLong(source));
    }
}