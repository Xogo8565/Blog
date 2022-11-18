package com.play.blog.auth;

import com.play.blog.auth.*;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class UserInfoFactory {
    public OAuth2UserInfo getOauth2UserInfo(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User){

        return switch (oAuth2UserRequest.getClientRegistration().getRegistrationId()){
            case "google" -> new GoogleAuthInfo(oAuth2User.getAttributes());
            default -> null;
        };
    }
}
