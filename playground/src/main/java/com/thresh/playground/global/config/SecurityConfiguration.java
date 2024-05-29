package com.thresh.playground.global.config;

import static com.thresh.playground.domain.user.entity.Role.ADMIN;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
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

  private static final String[] WHITE_LIST_URL = {
    "/api/v1/auth/**",
    "/v2/api-docs",
    "/v3/api-docs",
    "/v3/api-docs/**",
    "/swagger-resources",
    "/swagger-resources/**",
    "/configuration/ui",
    "/configuration/security",
    "/swagger-ui/**",
    "/webjars/**",
    "/swagger-ui.html"
  };
  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;

  //    private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            req ->
                req.requestMatchers(WHITE_LIST_URL)
                    .permitAll()
                    .requestMatchers("/api/v1/management/**")
                    .hasAnyRole(
                        ADMIN.name()
                        //                                        , MANAGER.name()
                        )
                    //                                .requestMatchers(GET,
                    // "/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(),
                    // MANAGER_READ.name())
                    //                                .requestMatchers(POST,
                    // "/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(),
                    // MANAGER_CREATE.name())
                    //                                .requestMatchers(PUT,
                    // "/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(),
                    // MANAGER_UPDATE.name())
                    //                                .requestMatchers(DELETE,
                    // "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(),
                    // MANAGER_DELETE.name())
                    .anyRequest()
                    .authenticated())
        .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
    //                .logout(logout ->
    //                        logout.logoutUrl("/api/v1/auth/logout")
    //                                .addLogoutHandler(logoutHandler)
    //                                .logoutSuccessHandler((request, response, authentication) ->
    // SecurityContextHolder.clearContext())
    //                )
    ;

    return http.build();
  }
}
