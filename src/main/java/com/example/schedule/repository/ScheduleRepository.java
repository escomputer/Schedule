package com.example.schedule.repository;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    ScheduleResponseDto saveSchedule(Schedule schedule);

    List<ScheduleResponseDto> findAll(String updatedAt, String author);

    Optional<ScheduleResponseDto> findById(Long id);


    ScheduleResponseDto updateSchedule(Schedule schedule);

    void deleteSchedule(Long id);


}