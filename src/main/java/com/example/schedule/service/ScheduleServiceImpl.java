    package com.example.schedule.service;

    import com.example.schedule.dto.ScheduleRequestDto;
    import com.example.schedule.dto.ScheduleResponseDto;
    import com.example.schedule.entity.Schedule;
    import com.example.schedule.repository.ScheduleRepository;
    import org.springframework.stereotype.Service;

    import java.time.LocalDateTime;
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

        @Override
        public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto, String password){
            ScheduleResponseDto scheduleDto = scheduleRepository.findById(id)
                    .stream()
                    .findFirst()        //optional로 반환 되어서 맨 첫번째것 = 어짜피 하나만 나온다.
                    .orElseThrow(()->new RuntimeException("일정을 찾을 수 없습니다."));

            Schedule updatedSchedule = new Schedule(
                    requestDto.getTask(),
                    requestDto.getAuthor(),
                    requestDto.getPassword()
            );

            if (!requestDto.getPassword().equals(password)) {
                throw new RuntimeException("비밀번호가 일치하지 않습니다.");
            }


            updatedSchedule.setTask(requestDto.getTask());
            updatedSchedule.setAuthor(requestDto.getAuthor());
            updatedSchedule.setUpdatedAt(LocalDateTime.now());


        return scheduleRepository.updateSchedule(updatedSchedule);
        }


        @Override
        public void deleteSchedule(Long id, String password) {

          scheduleRepository.deleteSchedule(id);

        }
    }