package com.global.todo.to_do_list.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "to_do_list")
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

//    // Corrected annotation for the relationship mapping
//    @OneToMany
//    @JoinColumn(name = "id", referencedColumnName = "to_do_list_id")
//    private List<ToDo> toDos;

    public ToDoList() {
    }

    public ToDoList(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}