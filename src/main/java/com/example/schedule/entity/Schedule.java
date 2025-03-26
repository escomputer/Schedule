package com.example.schedule.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Schedule {
    private Long id;
    private String task;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime changedAt;
    private String password;

    public Schedule(String task, String author, String password) {
        this.task = task;
        this.author = author;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.changedAt = LocalDateTime.now();
    }
}
