package com.play.blog.auth;

import java.util.Map;

public interface OAuth2UserInfo {
    String getProviderId();

    String getProvider();

    String getEmail();

    String getUserName();

    String getPicture();

    Map<String, Object> getAttributes();
}
