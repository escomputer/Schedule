package com.example.schedule.repository;

import com.example.schedule.entitiy.Schedule;

public interface ScheduleRepository {
    Schedule saveSchedule(Schedule schedule);
}
