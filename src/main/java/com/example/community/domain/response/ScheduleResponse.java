package com.example.community.domain.response;

import com.example.community.domain.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleResponse {
    private Long id;
    private String scheduleName;
    private LocalDateTime scheduleTime;
    private String meetingPlace;
    private String price;
    private int maxParticipation;
    private int participant;
    private String interest;
    private String memberName;
    private String memberImage;

    public ScheduleResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.scheduleName = schedule.getScheduleName();
        this.scheduleTime = schedule.getScheduleTime();
        this.meetingPlace = schedule.getMeetingPlace();
        this.price = schedule.getPrice();
        this.maxParticipation = schedule.getMaxParticipation();
        this.participant = schedule.getParticipant();
        this.interest = schedule.getInterest();
        this.memberName = schedule.getMemberName();
        this.memberImage = schedule.getMemberImage();
    }
}
