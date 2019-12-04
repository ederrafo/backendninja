package com.ederrafo.entity;


import javax.persistence.*;
import java.math.BigDecimal;

// La anotamos como una entity
@Entity
// la tabla sera en plural, x default se crearia con el nombre de la clase
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private String name;

    private String description;

    private BigDecimal price;

    private int hours;

    public Course() {
    }

    // cuando inicializamos los constructores siempre hay que dejar el x default

    public Course(int id, String name, String description, BigDecimal price, int hours) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
