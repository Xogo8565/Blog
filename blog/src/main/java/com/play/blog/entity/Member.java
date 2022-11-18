package com.play.blog.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "SEQ_MEMBER",
        initialValue = 1, allocationSize = 50
)
@NoArgsConstructor
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;
    private String username;
    private String email;
    private String imgUrl;
    private Role role;

    @Builder
    public Member(Long id, String username, String email, String imgUrl, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.imgUrl = imgUrl;
        this.role = role;
    }

    public void renewUsername(String userName) {
        if(!userName.equals(this.username)) this.username = userName;
    }
}
