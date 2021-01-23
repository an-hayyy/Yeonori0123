package com.example.yeonori1209;


import java.nio.charset.Charset;
import java.security.MessageDigest;

public class Security {

    public String getHash(String input) {
        StringBuffer result = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(input.getBytes(Charset.forName("UTF-8")));
            byte bytes[] = md.digest();
            for (int i = 0; i < bytes.length; i++) {
                result.append(
                        Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
