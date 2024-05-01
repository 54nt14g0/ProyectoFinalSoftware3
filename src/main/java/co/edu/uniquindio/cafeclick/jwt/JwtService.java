//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.cafeclick.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {
    private static final String SECRET_KEY = "1S2e3C4r5E6t7K8e9Y0c9A8f7E6c5L4i3C2k1S2e3B4a5S6t7I8a9N0a9L8e7J6a5N4d3R2o1S2a3N4t5I6a7G8o9";

    public String getToken(UserDetails usuario) {
        return this.getToken(new HashMap<>(), usuario);
    }

    public String getToken(HashMap<String, Object> extraClaims, UserDetails usuario) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(usuario.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1440000L))
                .signWith(SignatureAlgorithm.HS512, this.getKey())
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getCorreoFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String correo = this.getCorreoFromToken(token);
        return correo.equals(userDetails.getUsername()) && !this.isTokenExpired(token);
    }

    private Claims getAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(this.getKey()).build().parseClaimsJws(token).getBody();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = this.getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Date getExpiration(String token) {
        return this.getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return this.getExpiration(token).before(new Date());
    }
}
