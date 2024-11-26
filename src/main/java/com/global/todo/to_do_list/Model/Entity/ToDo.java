package com.global.todo.to_do_list.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo")
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
    @ManyToOne(cascade = CascadeType.PERSIST)  // Optional: Cascade persist if needed
    @JoinColumn(name = "to_do_list_id", referencedColumnName = "id")
    @JsonIgnore
    private ToDoList toDoList;

    @ManyToOne(cascade = CascadeType.PERSIST)  // Optional: Cascade persist if needed
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    @JsonIgnore
    private Priority priority;

    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
        this.reminderSent = false;  // Optionally set default reminderSent value
    }

}
