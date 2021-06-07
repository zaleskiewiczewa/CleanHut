package pl.coderslab.entity;


import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@ToString
@Entity
@Table(name = "cleaning")
public class Cleaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String cleaning;

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
