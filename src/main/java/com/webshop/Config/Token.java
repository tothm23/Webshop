package com.webshop.Config;

import com.webshop.Model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.TextCodec;

import java.util.Date;

/**
 *
 * @author tothm23
 */
public class Token {

    public static String createJwt(User u, long expirationMillis) {

        long nowMillis = System.currentTimeMillis();

        String token = Jwts.builder()
                .setIssuer("tothm23")
                .claim("id", u.getId())
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(new Date(nowMillis + expirationMillis))
                .signWith(
                        SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode("RXogbGVzeiBhIHRpdGtvcyBrdWxjcw==")
                )
                .compact();

        return token;
    }

    public static int decodeJwt(String token) {
        try {
            String secret = "RXogbGVzeiBhIHRpdGtvcyBrdWxjcw==";
            Jws<Claims> result = Jwts.parser().setSigningKey(TextCodec.BASE64.decode(secret)).parseClaimsJws(token);
            return 1;

        } catch (ExpiredJwtException | MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException ex) {
// Lejárt token            
// JWT expired at 2023-10-08T17:19:31Z. Current time: 2023-10-08T17:28:12Z, a difference of 521241 milliseconds.  Allowed clock skew: 0 milliseconds.
// System.err.println(ex.getMessage());
            return 2;

        }
    }

//    public static User getUserByToken(String token) {
//        byte[] secret = Base64.getDecoder().decode("RXogbGVzeiBhIHRpdGtvcyBrdWxjcw==");
//        Jws<Claims> result;
//        result = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(secret)).parseClaimsJws(token);
//        int id = result.getBody().get("id", Integer.class);
//        User u = new User(id);
//        return u;
//    }
//
//    public static Integer getUserIdByToken(String token) {
//        byte[] secret = Base64.getDecoder().decode("RXogbGVzeiBhIHRpdGtvcyBrdWxjcw==");
//        Jws<Claims> result;
//        result = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(secret)).parseClaimsJws(token);
//        Integer id = result.getBody().get("id", Integer.class);
//        return id;
//    }
}
