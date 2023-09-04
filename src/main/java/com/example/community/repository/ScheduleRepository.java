package com.example.community.repository;

import com.example.community.domain.entity.Community;
import com.example.community.domain.entity.Schedule;
import com.example.community.domain.request.ScheduleRequest;
import com.example.community.domain.response.ScheduleResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("select com.example.community.domain.response(s.id, s.scheduleName, s.scheduleTime, s.meetingPlace, s.price, s.maxParticipation, s.Participant)" +
            "from Schedule s " +
            "where s.community = :communitiId")
    List<Schedule> findAllByCommunity(@Param("communityId") Long communityId, ScheduleRequest request);

}
