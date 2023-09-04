package com.example.community.domain.response;

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
    private int Participant;
}
