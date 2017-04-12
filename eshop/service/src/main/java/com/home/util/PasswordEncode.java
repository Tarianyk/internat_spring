package com.home.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncode {

    private PasswordEncode() {
        throw new UnsupportedOperationException("Non instance for PasswordEncode.");
    }

    public static String encodePassword(String inPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(inPassword);
    }
}
