package test;

import java.util.Base64;

public class Convert_base64 {



    public String transformer(String fileContent) {
        String decodedString = new String(Base64.getDecoder().decode(fileContent));
        return  decodedString;
    }
    ;
}
