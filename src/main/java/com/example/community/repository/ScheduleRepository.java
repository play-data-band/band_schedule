package com.example.community.repository;

import com.example.community.domain.entity.Community;
import com.example.community.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
