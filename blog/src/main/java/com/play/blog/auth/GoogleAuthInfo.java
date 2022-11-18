package com.play.blog.auth;

import com.play.blog.entity.Member;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;

public class GoogleAuthInfo implements OAuth2UserInfo {
    private final Map<String, Object> attributes;

    public GoogleAuthInfo (Map<String, Object> attributes){
        this.attributes =   attributes;
    }

    @Override
    public String getProviderId() {
        return (String) attributes.get("sub");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getUserName() {
        return attributes.get("name")+"#"+((String)attributes.get("sub")).substring(0,5);
    }

    @Override
    public String getPicture() {
        return (String) attributes.get("picture");
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

}
