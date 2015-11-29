package in.gov.uidai.auth.sampleapp;

import java.io.*;
import java.security.MessageDigest;


public class DocumentHashing {


    public static String documentHash(File f) throws Exception {


       // File f=new File("C:\\Users\\Ujjwal\\Downloads\\Ujjwal_Jain.pdf");

        byte[] buf = new byte[8192];

        InputStream is = new FileInputStream(f);

        int c = 0;
        StringBuffer stringBuffer = new StringBuffer();

        while ((c = is.read(buf, 0, buf.length)) > 0) {
            stringBuffer.append(hashString(buf, "SHA-256"));
        }

        is.close();
        return stringBuffer.toString();

    }
    
    private static String hashString(byte[] message, String algorithm)
            throws Exception {
     
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hashedBytes = digest.digest(message);
     
            return convertByteArrayToHexString(hashedBytes);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }

}
