package com.thresh.playground.global.security2;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig2 {

  private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
  private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
  private final CustomLoginAuthenticationEntryPoint authenticationEntryPoint;
  private final AuthenticationConfiguration authenticationConfiguration;
  private final CustomAccessDeniedHandler accessDeniedHandler;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.csrf(AbstractHttpConfigurer::disable)
        .cors(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            request ->
                request
                    .requestMatchers("/api/auth/signup") // /api/auth/signup 경로는 인증 없이 접근 가능
                    .permitAll()
                    .requestMatchers("/api/**") // 그 외 /api/** 경로는 인증 필요
                    .authenticated()
                    .anyRequest() // 나머지 모든 요청은 인증 없이 접근 가능
                    .permitAll())
        .addFilterBefore(ajaxAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        .exceptionHandling(
            config ->
                config
                    .authenticationEntryPoint(authenticationEntryPoint)
                    .accessDeniedHandler(accessDeniedHandler));

    return http.build();
  }

  @Bean
  public CustomAuthenticationFilter2 ajaxAuthenticationFilter() throws Exception {
    CustomAuthenticationFilter2 customAuthenticationFilter = new CustomAuthenticationFilter2();
    customAuthenticationFilter.setAuthenticationManager(authenticationManager());
    customAuthenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
    customAuthenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler);

    // **
    customAuthenticationFilter.setSecurityContextRepository(
        new DelegatingSecurityContextRepository(
            new RequestAttributeSecurityContextRepository(),
            new HttpSessionSecurityContextRepository()));

    return customAuthenticationFilter;
  }

  @Bean
  public AuthenticationManager authenticationManager() throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }
}
