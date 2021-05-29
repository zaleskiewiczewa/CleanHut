package pl.coderslab.entity;
import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Table(name = "data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dates;

    @Size(min=1)
    @ManyToMany
    @JoinTable(name = "dates_rooms",
            joinColumns = @JoinColumn(name = "dates_id"),
            inverseJoinColumns = @JoinColumn(name = "rooms_id"))
    private List<Data> data = new ArrayList<>();

    public LocalDate getDates() {
        return dates;
    }

    public void setDates(LocalDate dates) {
        this.dates = dates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    }