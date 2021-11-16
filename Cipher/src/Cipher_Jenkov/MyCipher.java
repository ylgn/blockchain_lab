package Cipher_Jenkov;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class MyCipher {

	public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
		// TODO Auto-generated method stub
		Security.addProvider(new BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] keyBytes   = new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		IvParameterSpec ivspec = new IvParameterSpec(keyBytes);
		String algorithm  = "RawBytes";
		SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);
		//Initializing a Cipher object
	     cipher.init(Cipher.ENCRYPT_MODE, key,ivspec); 
	      //Add data to the cipher
	      byte[] input = "Welcome to Tutorialspoint".getBytes();	  
	      cipher.update(input);
		  
	      //encrypting the data
	      byte[] cipherText = cipher.doFinal();	 
	      System.out.println( new String(cipherText, "UTF8"));

	      //Initializing the same cipher for decryption
	      cipher.init(Cipher.DECRYPT_MODE,key,ivspec);
	      
	      //Decrypting the text
	      byte[] decipheredText = cipher.doFinal(cipherText);
	      System.out.println(new String(decipheredText));
		
				
			
	}

}
