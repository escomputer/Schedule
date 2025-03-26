package com.example.schedule.repository;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("schedules")
                .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("task", schedule.getTask());
        parameters.put("author", schedule.getAuthor());
        parameters.put("password", schedule.getPassword());
        parameters.put("created_at", schedule.getCreatedAt());
        parameters.put("updated_at", schedule.getUpdatedAt());

        Number key = jdbcInsert.executeAndReturnKey(parameters);

        // ID 값을 Schedule 객체에 세팅하고 반환
        schedule.setId(key.longValue());

        // ScheduleResponseDto로 변환하여 반환
        return new ScheduleResponseDto(schedule);
    }


    @Override
    public List<ScheduleResponseDto> findAll(String updatedAt, String author) {
        String sql = "SELECT * FROM schedules WHERE 1=1"; // 기본 조건
        List<Object> params = new ArrayList<>(); //where 1=1 일때 , 수정일자/작성자 에 대한 조건에 맞게 행동하려고 params란 리스트사용 (동적으로)

        // updatedAt을 입력했을 때 비교하는 것
        if (updatedAt != null && !updatedAt.isEmpty()) {
            sql += " AND DATE(updated_at) = ?";
            LocalDate updatedDate = LocalDate.parse(updatedAt, DateTimeFormatter.ISO_LOCAL_DATE); // ISO_LOCAL_DATE 국제 표준 상 yyyy-mm-dd임. 파싱한것이다.
            params.add(updatedDate);
        }

        // author를 입력했을 때 비교하는 것
        if (author != null && !author.isEmpty()) {
            sql += " AND author = ?";
            params.add(author);
        }

        sql += " ORDER BY created_at DESC"; // 수정일자 기준 내림차순 정렬
        //이거는 author이랑 updated_at이 입력되지않아도 무조건임

        return jdbcTemplate.query(sql, params.toArray(), (rs, rowNum) -> new ScheduleResponseDto(
                rs.getLong("id"),
                rs.getString("task"),
                rs.getString("author"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                rs.getTimestamp("updated_at").toLocalDateTime()
        ));
    }


}

