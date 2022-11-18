package com.play.blog.service;

import com.nimbusds.openid.connect.sdk.claims.UserInfo;
import com.play.blog.auth.OAuth2UserInfo;
import com.play.blog.auth.PrincipalDetails;
import com.play.blog.auth.UserInfoFactory;
import com.play.blog.entity.Member;
import com.play.blog.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomOauth2Service extends DefaultOAuth2UserService {
    private final UserInfoFactory userInfoFactory;
    private final MemberRepository memberRepository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User =  super.loadUser(userRequest);
        OAuth2UserInfo oAuth2UserInfo = userInfoFactory.getOauth2UserInfo(userRequest, oAuth2User);

        Member member = getOrJoinMember(oAuth2UserInfo);

        return new PrincipalDetails(oAuth2UserInfo.getAttributes(), member);
    }

    private Member getOrJoinMember(OAuth2UserInfo oAuth2UserInfo) {
        Member member = memberRepository.findByEmail(oAuth2UserInfo.getEmail())
                .orElseGet(()->signUp(oAuth2UserInfo));
        member.renewUsername(oAuth2UserInfo.getUserName());

        return member;
    }

    private Member signUp(OAuth2UserInfo oAuth2UserInfo) {
        memberRepository.findByEmail(oAuth2UserInfo.getEmail())
                .ifPresent(err -> {
                    throw new OAuth2AuthenticationException("duplicated");
                });
        Member member = oAuth2UserInfo.toEntity();
        memberRepository.save(member);

        return member;
    }
}
