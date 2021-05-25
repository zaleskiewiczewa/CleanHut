package pl.coderslab.entity;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import lombok.ToString;

@ToString
@Entity
@Table(name = "data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat
    private int dates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDates() {
        return dates;
    }

    public void setDates(int data) {
        this.dates = dates;
    }
}