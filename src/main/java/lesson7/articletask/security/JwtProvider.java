package lesson7.articletask.security;

//import io.jsonwebtoken.Jwts;
//import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lesson7.articletask.entity.Lavozim;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component
public class JwtProvider {
    long expireTime=36000*1000;
String secretKey="JakhongirShukhrat";

public String generateToken(String username, Lavozim lavozims){
    return Jwts
            .builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expireTime))
            .claim("roles",lavozims.getName())
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact();
}
public boolean validationToken(String token){
    try {
        Jwts
                .parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
        return true;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
    }
    public String getUsernameFromToken(String token) {

        return Jwts
                .parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }


}
