package pe.bk.appcambista.adapter.in.apis.rest.security;

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
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "8aac35c300cced02f755f881ce02b1bdb80cece6ec8a57476c059a3551fe347b";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //TODO: extraer token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //TODO: generer token por detalles de usuario
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    //TODO: generer token
    public String generateToken(Map<String, Objects> extractClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                //TODO: fecha de emision token
                .setIssuedAt(new Date(System.currentTimeMillis()))
                //TODO: fecha de caducidad token
                .setExpiration(new Date((new Date()).getTime() + 7200 * 24 * 60))
                //TODO: clave para firmar + algoritmo de firma
                .signWith(getSignInkey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //TODO: extraer todos los reclamos
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                //TODO: clave firma(firmar digitalmente el JWT)
                .setSigningKey(getSignInkey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInkey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //TODO: validamos token
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
