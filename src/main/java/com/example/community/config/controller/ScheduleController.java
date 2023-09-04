package com.example.community.config.controller;

import com.example.community.domain.request.ScheduleRequest;
import com.example.community.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public void findScheduleAll(Long communityId, ScheduleRequest request) {
        scheduleService.findAll(communityId, request);

    }

}
