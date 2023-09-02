package com.example.community.controller;

import com.example.community.domain.request.CommunityReqeust;
import com.example.community.domain.response.CommunityResponse;
import com.example.community.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/community")
public class CommunityController {
    private final CommunityService communityService;

    @PostMapping
    public void save(@RequestBody CommunityReqeust communityReqeust) throws Exception {
        communityService.save(communityReqeust);
    }

    @GetMapping("/{communityId}")
    public CommunityResponse findById(@PathVariable("communityId") Long communityId){
        return communityService.findById(communityId);
    }

    @GetMapping("/interest")
    public Page<CommunityResponse> findByInterest(@RequestParam(name = "interest") String interest,
                               @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                               @RequestParam(name = "size", required = false, defaultValue = "10") Integer size
                               ){
        return communityService.findAllByInterest(interest, PageRequest.of(page,size));
    }

    //ownerId
    @DeleteMapping("/{communityId}")
    public void deleteById(@PathVariable("communityId") Long communityId){
        communityService.deleteById(communityId);
    }

    @PutMapping("/{updateById}")
    public void updateById(@PathVariable("updateById") Long updateById,
                           @RequestBody CommunityReqeust communityReqeust){
        communityService.updateById(updateById, communityReqeust);
    }

}
