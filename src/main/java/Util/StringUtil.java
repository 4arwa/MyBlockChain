package Util;

import java.security.MessageDigest;

/**
 * Created by IntelliJ IDEA.
 * User: Arwa Arif  - arwaarif1994@gmail.com
 * Date: 19-Oct-18
 */
public class StringUtil {
    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String calculateHash(String previousHash, long time, String transaction, int nonce) {
        String calculatedhash = StringUtil.applySha256(previousHash + Long.toString(time) +
                Integer.toString(nonce) + transaction);
        return calculatedhash;
    }
}
