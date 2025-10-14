package com.hackaboss;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String key = "pajarito123cangrejo456ardilla789";    // almacenada en archivo properties o .env
        SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes());  // genero clave secreta

        Map<String, Object> claims = new HashMap<>();
        claims.put("rol", "admin");
        claims.put("email", "usuario@example.com");
        claims.put("activo", true);

        String jwt = Jwts.builder()
                .claims(claims) // agrega los claims personalizados
                .subject("usuario123")  // identificador del usuario
                .issuedAt(new Date())   // fecha de emisión
                .expiration(new Date(System.currentTimeMillis() + 3600000)) // expira en 1 hora
                .signWith(secretKey, Jwts.SIG.HS256)    // firma con la clave secreta
                .compact(); // serializa el jwt

        System.out.println("Tu JWT generado:");
        System.out.println(jwt);
    }
}