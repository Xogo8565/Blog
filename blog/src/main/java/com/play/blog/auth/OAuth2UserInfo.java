package com.play.blog.auth;

import com.play.blog.entity.Member;
import com.play.blog.entity.Role;

import java.util.Map;

public interface OAuth2UserInfo {
    String getProviderId();

    String getEmail();

    String getUserName();

    String getPicture();

    Map<String, Object> getAttributes();

    default Member toEntity(){
        return Member.builder()
                .username(this.getUserName())
                .email(this.getEmail())
                .imgUrl(this.getPicture())
                .role(Role.USER)
                .build();
    }
}
