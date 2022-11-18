package com.play.blog.config;

import com.play.blog.service.OauthService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private OauthService oauthService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();

        httpSecurity.authorizeRequests()
                .antMatchers("/user").authenticated()
                .antMatchers("/admin").hasRole("ROLE_ADMIN")
                .anyRequest()
                .permitAll();

        httpSecurity.formLogin();

        httpSecurity
                .logout()
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/");

        httpSecurity.oauth2Login().userInfoEndpoint()
                .userService(oauthService);

        return httpSecurity.build();
    }
}
