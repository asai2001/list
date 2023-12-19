package com.example.ParkirGo;

import com.example.ParkirGo.Dto.UsersDto;
import com.example.ParkirGo.Entity.Users;
import com.example.ParkirGo.Repository.UserRepo;
import com.example.ParkirGo.Service.UserService;
import com.example.ParkirGo.encryption.Vigenere64;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ParkirGoApplicationTests {

	@MockBean
	private UserRepo userRepo;

	@Autowired
	private UserService userService;

	@Test
	void testEncryptVigenere64() {
		Vigenere64 obj = new Vigenere64();
		String originalText = "Titik Permatasari";
		String key = "aris";
		String encryptText = obj.encrypt(originalText, key);
		String expectedEncrypText = "VFpCQUsgWFdSRElMQUpJSkk=";
		if (expectedEncrypText.equals(encryptText)) {
			System.out.println("Test Encrypt Vigenere64 method Passed");
		} else {
			System.out.println("Test Encrypt Vigenere64 method Failed");
			System.out.println("Expected : " + expectedEncrypText);
			System.out.println("Actual : " + encryptText);
		}

		assertEquals(expectedEncrypText, encryptText);
	}

	@Test
	void testDecryptVigenere64() {
		Vigenere64 obj = new Vigenere64();
		String encryptText = "VFpCQUsgWFdSRElMQUpJSkk=";
		String key = "aris";
		String decryptText = obj.decrypt(encryptText, key);
		String expectedDecrypt ="TITIK PERMATASARI";
		if (expectedDecrypt.equals(decryptText)) {
			System.out.println("Test Decrypt Vigenere64 Method Passed");
		} else {
			System.out.println("Test Decrypt Vigenere64 Method Failed");
			System.out.println("Expected : " + expectedDecrypt);
			System.out.println("Actual : " + decryptText);
		}
		assertEquals(expectedDecrypt, decryptText);
	}



}
