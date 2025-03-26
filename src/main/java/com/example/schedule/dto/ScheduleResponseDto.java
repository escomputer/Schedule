package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ScheduleResponseDto {
    private Long id;
    private String task;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id=schedule.getId();
        this.task=schedule.getTask();
        this.author=schedule.getAuthor();
        this.createdAt=schedule.getCreatedAt();
        this.updatedAt=schedule.getUpdatedAt();
    }
}
