package com.simft.simft.encryption;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Base64;

@JsonSerialize(using = Caesar64Serializer.class)
public class Caesar64 {
    public String encryptCaesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char encryptedChar = (char) (((ch - base + shift) % 26) + base);
                result.append(encryptedChar);
            } else if (Character.isDigit(ch)) {
                char encryptedChar = (char) (((ch - '0' + shift) % 10) + '0');
                result.append(encryptedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public String encryptBase64(String text) {
        byte[] bytes = text.getBytes();
        String encodedText = Base64.getEncoder().encodeToString(bytes);
        return encodedText;
    }

    public String decryptCaesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char decryptedChar = (char) (((ch - base - shift + 26) % 26) + base);
                result.append(decryptedChar);
            } else if (Character.isDigit(ch)) {
                char decryptedChar = (char) (((ch - '0' - shift + 10) % 10) + '0');
                result.append(decryptedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public String decryptBase64(String encodedText) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedText);
        String decodedText = new String(decodedBytes);
        return decodedText;
    }

    public int encryptInteger(int number, int shift) {
        // Enkripsi angka dengan pergeseran
        int encryptedNumber = (number + shift) % 10;
        return encryptedNumber;
    }

    public int decryptInteger(int number, int shift) {
        // Dekripsi angka dengan pergeseran
        int decryptedNumber = (number - shift + 10) % 10;
        return decryptedNumber;
    }

    public String encryptIntegerToBase64(int number, int shift) {
        // Enkripsi angka dengan pergeseran dan konversi ke Base64
        int encryptedNumber = (number + shift) % 10;
        String encryptedNumberString = String.valueOf(encryptedNumber);
        return encryptBase64(encryptedNumberString);
    }

    public int decryptIntegerFromBase64(String base64String, int shift) {
        // Mendekripsi string Base64 dan mengembalikan angka asli
        String decryptedNumberString = decryptBase64(base64String);
        int decryptedNumber = Integer.parseInt(decryptedNumberString);
        return (decryptedNumber - shift + 10) % 10;
    }

}
