package jwtToken.jwtplayground.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECKET_KEY = "7a3da8225db06e6259669441cdee2db7de9e2e8cade3ad55ac683b39fe7ae9f8";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // jwt 토큰에 있는 정보(claim)을 추출하기 위한 메서드
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // user 정보로만 토큰을 생성하기 위한 메서드
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    // 토근인지 확인하기 위한 메서드
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    // 토큰의 만료를 확인하는 메서드
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date()); // TODO before는 어떻게 동작하는지, 왜쓰는지 알아보기
    }

    // 만료를 추출하는 메서드
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // jwt 토큰을 어떻게 생성하는지 세팅하기 위한 메서드
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().
                setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECKET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
