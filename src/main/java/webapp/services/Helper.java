package webapp.services;

import java.util.Random;

public class Helper {
    public static String randomString(int len){
        String pattern = "1234567890wertyuiopasdfghjklzxcvbnm";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < len ; i ++){
            sb.append(pattern.charAt(random.nextInt(0,pattern.length())));
        }
        return sb.toString();
    }
}
