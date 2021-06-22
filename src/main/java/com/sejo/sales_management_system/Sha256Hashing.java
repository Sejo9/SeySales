package com.sejo.sales_management_system;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Hashing {

    public static String Hash(String originalString) throws NoSuchAlgorithmException {
        MessageDigest digest;
        byte[] encodedHash;

        digest = MessageDigest.getInstance("SHA-256");
        encodedHash = digest.digest(
                originalString.getBytes(StandardCharsets.UTF_8)
        );
        return bytesToHex(encodedHash);
    }

    private static String bytesToHex(byte[] hash){
        StringBuilder hexString = new StringBuilder(2 * hash.length);

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);

            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


}
