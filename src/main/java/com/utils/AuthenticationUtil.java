package com.utils;

import com.models.Authentication;
import com.services.AuthenticationService;
import com.services.impl.AuthenticationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.Base64;


public class AuthenticationUtil {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationUtil.class);

    public static String checkAuthentication(String authToken, AuthenticationService authenticationService) throws UnsupportedEncodingException {
        byte[] base64decodedBytes = Base64.getDecoder().decode(authToken.substring(6));
        logger.info("Checking Authentication for decoded authToken %s\n", base64decodedBytes);
        String auth = new String(base64decodedBytes, "UTF-8");
        String[] credentials = auth.split(":");
        logger.info("Checking Authentication for user %s, %s\n", credentials[0], credentials[1]);
        Authentication authentication = new Authentication(credentials[0], credentials[1]);
        String id = authenticationService.getId(authentication);
        logger.info("Found id %s\n", id);
        if(id == null) return "User Not Found";
        else return id;
    }
}
