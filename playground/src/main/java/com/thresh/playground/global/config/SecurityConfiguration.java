package com.thresh.playground.global.config;

import static com.thresh.playground.domain.user.entity.Role.ADMIN;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import com.thresh.playground.global.exception.Constants;
import com.thresh.playground.global.exception.CustomAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// 시작할 때 보안 체인을 찾을 거에요
// 필터들을 binding 해주기 위한 설정파일이에요
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final DaoAuthenticationProvider authenticationProvider;
  private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
        .cors(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            req ->
                req.requestMatchers(Constants.WHITE_LIST_URL.toArray(new String[0]))
                    .permitAll()
                    .requestMatchers("/api/v1/management/**")
                    .hasAnyRole(ADMIN.name())
                    .anyRequest()
                    .authenticated())
        .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
        .authenticationProvider(authenticationProvider)
        //        .exceptionHandling(
        //            exceptionHandling ->
        //
        // exceptionHandling.authenticationEntryPoint(customAuthenticationEntryPoint))
        //        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}
