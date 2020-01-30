package util;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class PasswordDigest {
	
	public static String digest(String password){
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] digest = md.digest(password.getBytes());
			String digestString = DatatypeConverter.printHexBinary(digest);
			return digestString;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
