package com.example.schedule.dto;

import com.example.schedule.entitiy.Schedule;

public class ScheduleResponseDto {
    private Long id;
    private String task;
    private String author;
    private String createdAt;
    private String changedAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id=schedule.getId();
        this.task=schedule.getTask();
        this.author=schedule.getAuthor();
        this.createdAt=schedule.getCreatedAt();
        this.changedAt=schedule.getChangedAt();
    }
}
