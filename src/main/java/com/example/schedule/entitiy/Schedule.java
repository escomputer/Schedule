package com.example.schedule.entitiy;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String task;
    private String author;
    private String createdAt;
    private String changedAt;
    private String password;

    public Schedule(String task, String author, String password) {

        this.task = task;
        this.author = author;
        this.password = password;
    }
}
