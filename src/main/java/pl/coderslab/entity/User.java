package pl.coderslab.entity;
import javax.persistence.*;
import lombok.ToString;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@ToString
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @Email
    private String email;

    @ManyToOne
    private Week week;

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    @ManyToMany
    @JoinTable (name = "cleaning_user",
    joinColumns = @JoinColumn(name = "cleaning_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Cleaning> cleanings = new ArrayList<>();


    public List<Cleaning> getCleanings() {
        return cleanings;
    }

    public void setCleanings(List<Cleaning> cleanings) {
        this.cleanings = cleanings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    }

