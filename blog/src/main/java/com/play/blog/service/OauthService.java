package com.play.blog.service;

import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OauthService extends DefaultOAuth2UserService {

}
