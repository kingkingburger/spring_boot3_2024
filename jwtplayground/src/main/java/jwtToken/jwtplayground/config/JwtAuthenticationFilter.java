package jwtToken.jwtplayground.config;

// jwt의 유효성에 대해 검사해요
// 가장 먼저 실행되는 필터에요.

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter { // http 요청당 1번의 필터링이 적용되요

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization"); // 헤더에서 토큰을 가져와요
        final String jwt;
        final String userEmail;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            // 나머지 필터를 안거치고 여기서 팅기기 위해 return을 해줘요
            return;
        }

        jwt = authHeader.substring(7); // header 문자열에서 Bearer 를 제외하기 위함이에요

        userEmail = jwtService.extractUsername(jwt);


    }
}
