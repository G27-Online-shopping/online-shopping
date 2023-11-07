package com.example.onlineshopping.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final String[] openEndpoints = {"/", "/sign-in", "/sign-up", "/css/**","/card","/product/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(
                        registry -> registry
                                .requestMatchers(openEndpoints).permitAll()
                                .anyRequest().authenticated()
                ).formLogin(
                        loginConfig -> loginConfig
                                .loginPage("/sign-in")
                                .defaultSuccessUrl("/", true)
                                .loginProcessingUrl("/sign-in")
                                .usernameParameter("email")
                                .passwordParameter("password")
                )
                .oauth2Login(oauth2LoginConfig -> {
                    oauth2LoginConfig
                            .loginPage("/oauth2/authorization")
                            .defaultSuccessUrl("/")
                            .failureUrl("/sign-in?error=true");
                })
                .logout(
                        logoutConfig -> logoutConfig
                                .logoutRequestMatcher(new AntPathRequestMatcher("/sign-out"))
                                .logoutSuccessUrl("/sign-in")
                )
                .rememberMe(
                        rememberMeConfig -> rememberMeConfig
                                .rememberMeCookieName("rememberMe")
                                .tokenValiditySeconds(3 * 60 * 60 * 24)
                                .rememberMeParameter("rememberMe")
                ).build();
    }
}
