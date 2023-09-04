package com.example.community.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequest {
    private String scheduleName;
    private LocalDateTime scheduleTime;
    private String meetingPlace;
    private String price;
    private int maxParticipation;
}
