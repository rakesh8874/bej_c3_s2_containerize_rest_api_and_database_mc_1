package com.niit.userlogindetails.service;
import com.niit.userlogindetails.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityGeneratorImpl implements ISecurityGenerator{
    @Override
    public Map<String, String> tockenGenerator(User user) {
        String jwtToken = null;
        jwtToken = Jwts.builder().setSubject(user.getUserName()).setIssuedAt(new Date()).
                signWith(SignatureAlgorithm.HS256,"securityKey").compact();

        Map<String ,String> map = new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","User Logged In Successfully");
        return map;
    }
}
