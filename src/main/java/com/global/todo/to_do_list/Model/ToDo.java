package com.global.todo.to_do_list.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "to_do")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private boolean completed;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "to_do_list_id", insertable = false, updatable = false)
    private int toDoListId;

    // Corrected annotation for the relationship mapping
    @ManyToOne
    @JoinColumn(name = "to_do_list_id", referencedColumnName = "id")
    private ToDoList toDoList;

    // Getters and Setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public int getToDoListId() {
        return toDoListId;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    // Constructor
    public ToDo() {
    }

    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
    }

    public ToDo(int id, String title, String description, boolean completed, LocalDateTime createDate, ToDoList toDoList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createDate = createDate;
        this.toDoList = toDoList;
    }
}