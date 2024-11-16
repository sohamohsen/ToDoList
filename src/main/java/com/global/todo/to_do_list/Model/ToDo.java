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

    @Column(name = "due_date")
    private LocalDateTime dueDate; // due date field

    @Column(name= "reminder", nullable = false, columnDefinition = "boolean default false")
    private boolean reminderSent; // reminder sent flag

    @Column(name = "to_do_list_id", insertable = false, updatable = false)
    private int toDoListId;

    @Column(name = "priority_id", insertable = false, updatable = false)
    private int priorityId;

    // Corrected annotation for the relationship mapping
    @ManyToOne
    @JoinColumn(name = "to_do_list_id", referencedColumnName = "id")
    private ToDoList toDoList;

    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    private Priority priority;

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

    public void setToDoListId(int toDoListId) {
        this.toDoListId = toDoListId;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    // Constructor
    public ToDo() {
    }

    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isReminderSent() {
        return reminderSent;
    }

    public void setReminderSent(boolean reminderSent) {
        this.reminderSent = reminderSent;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    public ToDo(int id, String title, String description, boolean completed, LocalDateTime createDate, LocalDateTime dueDate, boolean reminderSent, int toDoListId, int priorityId, ToDoList toDoList, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createDate = createDate;
        this.dueDate = dueDate;
        this.reminderSent = reminderSent;
        this.toDoListId = toDoListId;
        this.priorityId = priorityId;
        this.toDoList = toDoList;
        this.priority = priority;
    }
}