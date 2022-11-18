package com.play.blog.auth;

import com.play.blog.entity.Member;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


import java.util.Collection;
import java.util.Map;

@AllArgsConstructor
public class PrincipalDetails implements org.springframework.security.oauth2.core.user.OAuth2User {
    private final Map<String, Object> attributes;
    private final Member member;

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getName() {
        return member.getUsername();
    }
}
