package com.play.blog.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "SEQ_MEMBER",
        initialValue = 1, allocationSize = 50
)
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;
    private String username;
    private String email;
    private String imgUrl;
    private Role role;
    private String provider;

    @Builder
    public Member(Long id, String username, String email, String imgUrl, Role role, String provider) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.imgUrl = imgUrl;
        this.role = role;
        this.provider = provider;
    }
}
