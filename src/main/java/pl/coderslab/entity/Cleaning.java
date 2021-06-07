package pl.coderslab.entity;


import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Table(name = "cleaning")
public class Cleaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String cleaning;

    @ManyToMany (mappedBy = "cleaning")
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCleaning() {
        return cleaning;
    }

    public void setCleaning(String cleaning) {
        this.cleaning = cleaning;
    }
}
