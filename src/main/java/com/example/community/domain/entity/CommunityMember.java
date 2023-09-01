package com.example.community.domain.entity;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "CommunityMembers")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long communityId;
    private Long memberId;
    private String communityName;
    private String communityImage;
    private String memberRole;
    private String memberName;
    private String memberImage;


}
