package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {


    List<ScheduleResponseDto> getScheduleById(Long id);

    ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto);

    List<ScheduleResponseDto> getSchedules(String updatedAt, String author);
}
