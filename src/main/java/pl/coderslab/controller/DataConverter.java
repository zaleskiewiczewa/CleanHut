package pl.coderslab.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Data;
import pl.coderslab.repository.DataRepository;

public class DataConverter implements Converter<String, Data> {

    @Autowired
    private DataRepository repository;

    @Override
    public Data convert(String source) {
        return repository.findById(Long.parseLong(source));
    }
}