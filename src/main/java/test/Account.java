package test;

import java.util.Arrays;
import java.util.Base64;

public class Account {
	
	public String create(String fileContent) {
		System.out.println("----------- create receives: " + fileContent);
		return "Account created for " + fileContent;
	}
	public String transformer(String fileContent) {
		String decodedString = new String(Base64.getDecoder().decode(fileContent));
		System.out.println(fileContent);
		System.out.println(decodedString);

		return  decodedString;
	}
}
