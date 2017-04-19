package com.reference.spring.security.security;

import com.reference.spring.security.model.JwtUser;
import com.reference.spring.security.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by Srj on 9/6/16.
 */
@Component
public class TokenUtils {

    private String secret = "jwt.secret";

    User user = new User();
    public User parseToken(String token){
        try{
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();


           user.setUsername(body.getSubject());
            user.setId((int)body.get("userid"));
            return user;

        }catch(JwtException | ClassCastException e) {
            return  null;
        }
    }

    public String generateToken(JwtUser user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("userid", user.getUserid());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails){

        JwtUser user = (JwtUser) userDetails;
        final String username = this.parseToken(token).getUsername();
        final int userid = this.parseToken(token).getId();
        return (username.equals(user.getUsername()) && userid == user.getUserid());
    }
}
