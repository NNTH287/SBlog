package vn.edu.fpt.sblog_api_gateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Date;

public class JwtUtil {
    private JwtUtil() {}

    //This secret key should be stored in other place such as encrypted Config Server or Secret Management System
    private static final String SECRET = "yourSecretKey";

    public static Claims extractClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET).build().parseClaimsJws(token).getBody();
    }

    public static boolean isExpired(String token ) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public static boolean isValid(String token) {
        Claims claims = extractClaims(token);

        return claims.getSubject() != null && claims.get("role") != null && !isExpired(token);
    }
}
