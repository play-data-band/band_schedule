package com.example.community.repository;

import com.example.community.domain.entity.QCommunityMember;
import com.example.community.domain.request.CommunityMemberReqeust;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomCommunityMemberRepositoryImpl implements CustomCommunityMemberRepository{
    private final JPAQueryFactory queryFactory;
    private QCommunityMember qCommunityMember;

    @Override
    public void updateCommunityInCommunityMember(CommunityMemberReqeust communityMemberReqeust) {
        JPAUpdateClause updateClause = queryFactory.update(qCommunityMember);
        if(communityMemberReqeust.getCommunityImage() != null){
            updateClause.set(qCommunityMember.communityImage,communityMemberReqeust.getCommunityImage());
        }

        if(communityMemberReqeust.getCommunityName() != null){
            updateClause.set(qCommunityMember.communityName, communityMemberReqeust.getCommunityName());
        }
        BooleanExpression whereCondition = qCommunityMember.communityId.eq(communityMemberReqeust.getCommunityId());
        updateClause.where(whereCondition);
        updateClause.execute();
    }

    @Override
    public void updateMemberInCommunityMember(CommunityMemberReqeust communityMemberReqeust) {
        JPAUpdateClause updateClause = queryFactory.update(qCommunityMember);
        if(communityMemberReqeust.getMemberImage() != null){
            updateClause.set(qCommunityMember.memberImage,communityMemberReqeust.getMemberImage());
        }

        if(communityMemberReqeust.getMemberName() != null){
            updateClause.set(qCommunityMember.memberName, communityMemberReqeust.getMemberName());
        }

        if(communityMemberReqeust.getMemberRole() != null){
            updateClause.set(qCommunityMember.memberRole, communityMemberReqeust.getMemberRole());
        }

        BooleanExpression whereCondition = qCommunityMember.memberId.eq(communityMemberReqeust.getMemberId());
        updateClause.where(whereCondition);
        updateClause.execute();
    }
}
