package com.example.userms.util;

import com.example.userms.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class TokenUtil {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public String generateToken(String username) {
        long currentMillis = System.currentTimeMillis();
        long expiryMillis = currentMillis + (60 * 60 * 1000 * 2);
        Date expiryDate = new Date(expiryMillis);
        String token = Jwts.builder()
                .signWith(key)
                .setSubject(username)
                .setExpiration(expiryDate)
                .compact();
        return token;
    }

    public String decodeToken(String token) throws InvalidTokenException {
       if(token==null || token.isEmpty()){
           throw new InvalidTokenException("Invalid Token");
       }
       token=token.trim();
       Jws<Claims> jws=Jwts.parserBuilder()
               .setSigningKey(key)
               .build()
               .parseClaimsJws(token);
       Claims claims=jws.getBody();
       String username=claims.getSubject();
       return username;
    }


}
