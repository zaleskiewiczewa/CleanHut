package pl.coderslab.entity;
import javax.persistence.*;
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
    private String dates;
    private String rooms;

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    @ManyToMany
    @JoinTable(name = "dates_rooms",
            joinColumns = @JoinColumn(name = "dates_id"),
            inverseJoinColumns = @JoinColumn(name = "rooms_id"))

    private List<Space> spaces=new ArrayList<>();

    public List<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Space> spaces) {
        this.spaces = spaces;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}