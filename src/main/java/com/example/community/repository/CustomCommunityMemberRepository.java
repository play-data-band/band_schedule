package com.example.community.repository;

import com.example.community.domain.request.CommunityMemberReqeust;

public interface CustomCommunityMemberRepository {
    void updateCommunityInCommunityMember(CommunityMemberReqeust communityMemberReqeust, Long communityId);

    void updateMemberInCommunityMember(CommunityMemberReqeust communityMemberReqeust, Long memberID);

}
