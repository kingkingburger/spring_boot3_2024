package com.thresh.playground.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thresh.playground.global.exception.Constants;
import com.thresh.playground.global.exception.ErrorCode;
import com.thresh.playground.global.exception.ExceptionFunction;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter { // http 요청당 1번의 필터링이 적용되요

  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;
  private final ExceptionFunction exceptionFunction;
  private final AntPathMatcher pathMatcher = new AntPathMatcher();

  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain)
      throws ServletException, IOException {

    String requestPath = request.getServletPath();
    boolean isWhiteListed =
        Constants.WHITE_LIST_URL.stream().anyMatch(url -> pathMatcher.match(url, requestPath));

    if (isWhiteListed) {
      filterChain.doFilter(request, response);
      return;
    }

    final String authHeader = request.getHeader("Authorization"); // 헤더에서 토큰을 가져와요
    final String jwt;
    final String userEmail;

    try {
      if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        throw new RuntimeException("토큰 정보를 확인하세요");
        //        return; // 나머지 필터를 안 거치고 여기서 팅기기 위해 return을 해줘요
      }

      jwt = authHeader.substring(7); // header 문자열에서 Bearer 를 제외하기 위함이에요

      userEmail = jwtService.extractUsername(jwt);

      // SecurityContextHolder를 사용함으로서 다음 필터링에 들어가지 않아요
      // Authentication이 null이라면 아직 인증 받지 못한 user라는 뜻이에요
      if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        // db에서 user 정보를 가지고 와요
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
        if (jwtService.isTokenValid(jwt, userDetails)) {
          // 유저 정보(id, pw)를 검증하기 위한 객체
          UsernamePasswordAuthenticationToken authToken =
              new UsernamePasswordAuthenticationToken(
                  userDetails, null, userDetails.getAuthorities());

          authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(authToken);
        }
      }
      // 다음에 실행할 필터를 호출해요
      filterChain.doFilter(request, response);
    } catch (ExpiredJwtException e) {
      exceptionFunction.apiException(ErrorCode.INVALID_TOKEN, "토큰이 만료되었습니다.", response);
    } catch (RuntimeException e) {
      exceptionFunction.apiException(ErrorCode.INVALID_TOKEN, "토큰 정보를 확인하세요", response);
    }
  }
}
