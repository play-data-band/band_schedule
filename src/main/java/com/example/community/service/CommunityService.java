package com.example.community.service;


import com.example.community.domain.entity.Community;
import com.example.community.domain.request.CommunityReqeust;
import com.example.community.domain.response.CommunityResponse;
import com.example.community.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final CommunityRepository communityRepository;

    public void save(CommunityReqeust communityReqeust) throws Exception {
        try {
            communityRepository.save(communityReqeust.toEntity());
        }catch (Exception e){
            throw new Exception("Community Save Failed");
        }
    };

    public Page<Community> findAllByMemberId(String memberId){
        // 커뮤니티 구성원 테이블 이용해서 맴버 개인 해당 커뮤니티 리턴=> 이 로직은 이 테이블에서 할게 아니다
        return null;
    }

    // 관심사 커뮤니티 리턴(추천 시스템)
    public Page<CommunityResponse> findAllByInterest(String interest, PageRequest pageRequest){
        return communityRepository.findAllByInterest("%"+interest+"%", pageRequest);
    }

    public CommunityResponse findById(Long communityId){
        return communityRepository.findByCommunityId(communityId);
    }

    public void deleteById(Long communityId){
        //여기서 communityMember 테이블에 커뮤니티 가입한 멤버도 싹 다 날려야함
        //원한다면 멤버에게 커뮤니티 삭제됐다고 알리는 로직도 필요함
        communityRepository.deleteById(communityId);
    }

    public void updateById(Long communityId, CommunityReqeust communityReqeust){
        Community community= communityReqeust.toEntity();
        community.setId(communityId);
        communityRepository.save(community);
    }




}
