package com.play.blog.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProviderType {

    GOOGLE("google");

    private final String value;

}