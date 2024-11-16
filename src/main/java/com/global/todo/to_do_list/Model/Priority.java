package com.global.todo.to_do_list.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Priorities")
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Priority(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Priority() {
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
}
