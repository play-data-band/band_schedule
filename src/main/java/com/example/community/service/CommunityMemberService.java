package com.example.community.service;

import com.example.community.domain.entity.CommunityMember;
import com.example.community.domain.request.CommunityMemberReqeust;
import com.example.community.domain.request.CommunityReqeust;
import com.example.community.repository.CommunityMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityMemberService {
    private final CommunityMemberRepository communityMemberRepository;

    public void saveCommunityMember(
            CommunityMemberReqeust communityMemberReqeust,
            Long communityId)
    {
        communityMemberRepository.save(communityMemberReqeust.toEntity(communityId));
    }


    //커뮤니티 구성원은 인원수가 많을 것 같지 않아서 페이지 대신 리스트로 뽑음
    public List<CommunityMember> findByCommunityId(Long communityId){
        return communityMemberRepository.findAllByCommunityId(communityId);
    }

    public List<CommunityMember> findAllByMemberId(Long memberId){
        return communityMemberRepository.findAllByMemberId(memberId);
    }

    public void updateCommunityInCommunityMember(CommunityMemberReqeust communityMemberReqeust){
        communityMemberRepository.updateCommunityInCommunityMember(communityMemberReqeust);
    };

    public void updateMemberInCommunityMember(CommunityMemberReqeust communityMemberReqeust){
        communityMemberRepository.updateMemberInCommunityMember(communityMemberReqeust);
    };

    public void deleteCommunityMember(Long memberId, Long communityId){
        communityMemberRepository.deleteByMemberIdAndCommunityId(memberId, communityId);
    }

}
