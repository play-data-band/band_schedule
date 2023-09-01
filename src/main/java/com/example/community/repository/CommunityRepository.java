package com.example.community.repository;

import com.example.community.domain.entity.Community;
import com.example.community.domain.entity.Schedule;
import com.example.community.domain.response.CommunityResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommunityRepository extends JpaRepository<Community, Long> {
    @Query("select new com.example.community.domain.response.CommunityResponse(c.id, c.name, c.category, c.interest, c.description, c.profileImage ) " +
            "from Community c " +
            "where c.id = :communityId ")
    CommunityResponse findByCommunityId(@Param("communityId") Long communityId);

    @Query("select new com.example.community.domain.response.CommunityResponse(c.id, c.name, c.category, c.interest, c.description, c.profileImage ) " +
            "from Community c " +
            "where c.interest = :interest ")
    Page<CommunityResponse> findAllByInterest(@Param("interest") String interest, PageRequest pageRequest);
}
