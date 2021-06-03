package pl.coderslab.entity;
import javax.persistence.*;
import lombok.ToString;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Table(name = "data")
public class Data<datalist> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dates;


    @ManyToMany
    @JoinTable(name = "dates_rooms",
            joinColumns = @JoinColumn(name = "dates_id"),
            inverseJoinColumns = @JoinColumn(name = "rooms_id"))

    private List<Data> dateList=new ArrayList<>();

    public int getDates() {
        return dates;
    }

    public void setDates(int dates) {
        this.dates = dates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}