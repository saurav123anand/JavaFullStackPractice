package com.example.userms.util;

import com.example.userms.exception.InvalidTokenException;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {
    public String generateToken(String username){
        long currentMillis=System.currentTimeMillis();  //9
        long expiryMillis=currentMillis+(60*60*1000);  //10
        String token=username+","+expiryMillis;
        return token;
    }
    public String decodeToken(String token) throws InvalidTokenException { //scooby,1669196658382
        if(token==null || token.isEmpty()){
            throw new InvalidTokenException("Invalid Token");
        }
        String[] parts=token.split(",");
        if(parts.length<2){
            throw new InvalidTokenException("Invalid Token");
        }
        String username=parts[0];
        String expiry=parts[1]; //10
        long currentMillis=System.currentTimeMillis(); //9
        long expiryMillis=Long.parseLong(expiry);  //10
        if(currentMillis>expiryMillis){
            throw new InvalidTokenException("Token has expired");
        }
        return username; //scooby

    }




}
