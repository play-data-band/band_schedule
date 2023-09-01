package com.example.community.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "Communities")
@Entity @Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String category;
    private String interest;
    private String description;
    private String profileImage;
    @OneToMany(mappedBy = "community")
    private List<Schedule> schedules;

}