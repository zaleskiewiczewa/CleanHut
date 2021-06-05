package pl.coderslab.entity;
import javax.persistence.*;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Table(name = "activities")
public class Activities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String activities;

    @ManyToMany (mappedBy = "activities")
    private List<User>users=new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "id=" + id +
                ", activities='" + activities + '\'' +
                ", users=" + users +
                '}';
    }
}