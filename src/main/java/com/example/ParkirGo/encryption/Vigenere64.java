package com.example.ParkirGo.encryption;

import java.util.Base64;

public class Vigenere64 {
    public String encrypt(String plainText, String key) {
        // Inisialisasi objek StringBuilder untuk menampung hasil enkripsi
        StringBuilder encryptedText = new StringBuilder();

        // Konversi teks dan kunci ke dalam bentuk huruf besar
        plainText = plainText.toUpperCase();
        key = key.toUpperCase();

        // Panjang teks dan kunci
        int textLength = plainText.length();
        int keyLength = key.length();

        // Loop melalui setiap karakter pada teks
        for (int i = 0; i < textLength; i++) {
            char plainChar = plainText.charAt(i);
            char keyChar = key.charAt(i % keyLength); // Menangani kunci yang lebih pendek

            // Enkripsi karakter menggunakan Vigenere Cipher
            char encryptedChar = encryptChar(plainChar, keyChar);

            // Tambahkan karakter terenkripsi ke dalam StringBuilder
            encryptedText.append(encryptedChar);
        }

        // Menggunakan Base64 untuk mengonversi teks terenkripsi ke dalam bentuk string
        return Base64.getEncoder().encodeToString(encryptedText.toString().getBytes());
    }

    public String decrypt(String encryptedText, String key) {
        // Menggunakan Base64 untuk mendekode teks terenkripsi dari bentuk string
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        String decodedText = new String(decodedBytes);

        // Inisialisasi objek StringBuilder untuk menampung hasil dekripsi
        StringBuilder decryptedText = new StringBuilder();

        // Konversi teks dan kunci ke dalam bentuk huruf besar
        decodedText = decodedText.toUpperCase();
        key = key.toUpperCase();

        // Panjang teks dan kunci
        int textLength = decodedText.length();
        int keyLength = key.length();

        // Loop melalui setiap karakter pada teks
        for (int i = 0; i < textLength; i++) {
            char decodedChar = decodedText.charAt(i);
            char keyChar = key.charAt(i % keyLength); // Menangani kunci yang lebih pendek

            // Dekripsi karakter menggunakan Vigenere Cipher
            char decryptedChar = decryptChar(decodedChar, keyChar);

            // Tambahkan karakter terdekripsi ke dalam StringBuilder
            decryptedText.append(decryptedChar);
        }

        return decryptedText.toString();
    }

    public char encryptChar(char plainChar, char keyChar) {
        if (Character.isLetter(plainChar)) {
            // Jika karakter adalah huruf, enkripsi menggunakan Vigenere Cipher
            return (char) (((plainChar - 'A' + keyChar - 'A') % 26) + 'A');
        } else {
            // Jika bukan huruf, biarkan karakter tersebut tidak berubah
            return plainChar;
        }
    }

    public char decryptChar(char encryptedChar, char keyChar) {
        if (Character.isLetter(encryptedChar)) {
            // Jika karakter adalah huruf, dekripsi menggunakan Vigenere Cipher
            int result = (encryptedChar - keyChar + 26) % 26;
            return (char) (result + 'A');
        } else {
            // Jika bukan huruf, biarkan karakter tersebut tidak berubah
            return encryptedChar;
        }
    }

//    public static void main(String[] args) {
//        // Contoh penggunaan
//        String plainText = "HelloWorld";
//        String key = "KEY";
//
//        // Enkripsi
//        String encryptedText = encrypt(plainText, key);
//        System.out.println("Encrypted Text: " + encryptedText);
//
//        // Dekripsi
//        String decryptedText = decrypt(encryptedText, key);
//        System.out.println("Decrypted Text: " + decryptedText);
//    }
}

