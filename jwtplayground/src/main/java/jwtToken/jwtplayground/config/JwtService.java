package jwtToken.jwtplayground.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECKET_KEY = "7a3da8225db06e6259669441cdee2db7de9e2e8cade3ad55ac683b39fe7ae9f8";

    public String extractUsername(String token) {
        return null;
    }

    // jwt 토큰에 있는 정보(claim)을 추출하기 위한 메서드
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
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
