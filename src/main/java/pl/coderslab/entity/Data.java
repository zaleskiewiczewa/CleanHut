package pl.coderslab.entity;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Table(name = "data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "MM/dd/yyyyy")
    private int dates;

    @Size(min=1)
    @ManyToMany
    @JoinTable(name = "dates_rooms",
            joinColumns = @JoinColumn(name = "dates_id"),
            inverseJoinColumns = @JoinColumn(name = "rooms_id"))
    private List<Data> data = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDates() {
        return dates;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public void setDates(int data) {
        this.dates = dates;
    }


    }