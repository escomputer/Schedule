    package com.example.schedule.service;

    import com.example.schedule.dto.ScheduleRequestDto;
    import com.example.schedule.dto.ScheduleResponseDto;
    import com.example.schedule.entity.Schedule;
    import com.example.schedule.repository.ScheduleRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class ScheduleServiceImpl implements ScheduleService {

        private final ScheduleRepository scheduleRepository;

        public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
            this.scheduleRepository = scheduleRepository;
        }

        @Override
        public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
            Schedule schedule = new Schedule(requestDto.getTask(), requestDto.getAuthor(), requestDto.getPassword());

            return scheduleRepository.saveSchedule(schedule);
        }

        @Override
        public List<ScheduleResponseDto> getSchedules(String updatedAt, String author) {
            return scheduleRepository.findAll(updatedAt,author);
        }

        @Override
        public Optional<ScheduleResponseDto> getScheduleById(Long id) {
            return scheduleRepository.findById(id);
        }


    }