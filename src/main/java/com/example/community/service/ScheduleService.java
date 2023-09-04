package com.example.community.service;

import com.example.community.domain.entity.Community;
import com.example.community.domain.entity.Schedule;
import com.example.community.domain.request.ScheduleRequest;
import com.example.community.domain.response.ScheduleResponse;
import com.example.community.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public void save(ScheduleRequest request) {

        Schedule schedule = Schedule.builder()
                .scheduleName(request.getScheduleName())
                .scheduleTime(LocalDateTime.now())
                .meetingPlace(request.getMeetingPlace())
                .price(request.getPrice())
                .maxParticipation(request.getMaxParticipation())
                .build();
        scheduleRepository.save(schedule);
    }

    public List<Schedule> findAll(Long communityId, ScheduleRequest request) {
//        List<Schedule> allByCommunity = scheduleRepository.findAllByCommunity(communityId)
//                .stream().map();
        return scheduleRepository.findAllByCommunity(communityId, request);
    }

    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).get();
        scheduleRepository.delete(schedule);
    }

}
