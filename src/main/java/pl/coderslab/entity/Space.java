package pl.coderslab.entity;
import javax.persistence.*;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@ToString
@Entity
@Table(name = "rooms")
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String rooms;

    @ManyToMany (mappedBy = "dates")
    private List<Data> data=new ArrayList<>();

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

}