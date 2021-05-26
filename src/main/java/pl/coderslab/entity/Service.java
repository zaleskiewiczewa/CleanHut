package pl.coderslab.entity;
import javax.persistence.*;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String services;

    @ManyToMany (mappedBy = "users")
    private List<User>users=new ArrayList<>();

    public List<User> getUsers() { return users; }

    public void setUsers(List<User> users) { this.users = users; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getServices() {
        return services;
    }

    public void setServices(String service) {
        this.services = services;
    }

}