package com.global.todo.to_do_list.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add this field if it's missing
    private String name;

    // Other fields and methods...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
