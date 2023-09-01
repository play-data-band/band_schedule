package com.example.community.repository;

import com.example.community.domain.request.CommunityMemberReqeust;

public interface CustomCommunityMemberRepository {
    void updateCommunityInCommunityMember(CommunityMemberReqeust communityMemberReqeust);

    void updateMemberInCommunityMember(CommunityMemberReqeust communityMemberReqeust);

}
