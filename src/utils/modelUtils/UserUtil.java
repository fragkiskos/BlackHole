package utils.modelUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import utils.RandomString;
import model.User;

public class UserUtil {
	
	public static boolean createUser(String name,String username,String email,String sirname,String phone,String loginService){
		try{
			Date now = new Date();
			RandomString rs = new RandomString(8);
			String password =rs.nextString();
			String passwordMd5="";
			try {
				 passwordMd5 = makeSHA1Hash(password);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			User user = new User(username, email, name, sirname, phone, loginService, false, passwordMd5, "", "", 1000.0, true, now, null);
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}
	
	public static String makeSHA1Hash(String input)
            throws NoSuchAlgorithmException
        {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.reset();
            byte[] buffer = input.getBytes();
            md.update(buffer);
            byte[] digest = md.digest();

            String hexStr = "";
            for (int i = 0; i < digest.length; i++) {
                hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
            }
            return hexStr;
        }

}
