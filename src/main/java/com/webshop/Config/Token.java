package com.webshop.Config;
 
import com.webshop.Model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.security.Keys;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
 
/**
 *
 * @author tothm23
 */
public class Token {
    public static String createJwt(User u) {
 
        Instant now = Instant.now();
        int id = u.getId();
        String role;
//        if (u.isAdmin()) {
//            role = "superadmin";
//        } else {
//            role = "user";
//        }
        String token = Jwts.builder()
                .setIssuer("Dualis")
                .setSubject("Nappali Csoport")
                .claim("id", id)
//                .claim("scope", role)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(7, ChronoUnit.DAYS)))
                .signWith(
                        SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode("RXogbGVzeiBhIHRpdGtvcyBrdWxjcw==")
                )
                .compact();
 
        return token;
    }
 
    public static int decodeJwt(String token) {
        try {
            byte[] secret = Base64.getDecoder().decode("RXogbGVzeiBhIHRpdGtvcyBrdWxjcw==");
            Jws<Claims> result;
            result = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(secret)).parseClaimsJws(token);
            return 1;
 
        } 
        catch (Exception ex) {
            System.err.println("Hiba: " + ex.getMessage());
            //A token lejárt
            return 2;
        }
 
    }
 
    public static User getUserByToken(String token) {
        byte[] secret = Base64.getDecoder().decode("RXogbGVzeiBhIHRpdGtvcyBrdWxjcw==");
        Jws<Claims> result;
        result = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(secret)).parseClaimsJws(token);
        int id = result.getBody().get("id", Integer.class);
        User u = new User(id);
        return u;
    }
 
    public static Integer getUserIdByToken(String token) {
        byte[] secret = Base64.getDecoder().decode("RXogbGVzeiBhIHRpdGtvcyBrdWxjcw==");
        Jws<Claims> result;
        result = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(secret)).parseClaimsJws(token);
        Integer id = result.getBody().get("id", Integer.class);
        return id;
    }
}