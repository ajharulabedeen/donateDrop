package com.donatedrop.other;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestAny {

    @Test
    public void testBCrypt() {
        System.out.println("Test!");
        int i = 0;
        while (i < 10) {
            String password = "password";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);

            System.out.println(hashedPassword);
            i++;
        }
    }

}
