package sg.com.ioutlet.ace.password;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
public class PasswordUtil {

	private static final String ALGO = "SHA-256";
	
		private static final String CHARSET = "UTF8";
	
		public static String encodePassword(String password, byte[] salt) throws Exception
		{
			byte[] storedPassword;
			SecureRandom secureRandom = new SecureRandom();
			if (salt == null)
			{
				salt = new byte[12];
				secureRandom.nextBytes(salt);
			}
	
			MessageDigest md = MessageDigest.getInstance(ALGO);
			md.update(salt);
			md.update(password.getBytes());
			byte[] digest = md.digest();
			storedPassword = new byte[digest.length + 12];
	
			System.arraycopy(salt, 0, storedPassword, 0, 12);
			System.arraycopy(digest, 0, storedPassword, 12, digest.length);
	
			return new String(Base64.encodeBase64(storedPassword));
		}
	
		public static boolean isPasswordMatched(String inputPassword, String storedPassword) throws Exception
		{
			byte[] storedPasswordBytesWithSalt = Base64.decodeBase64(storedPassword.getBytes());
			if (storedPasswordBytesWithSalt.length < 12)
			{
				throw new Exception("THE STORED DATA/PASSWORD IS CORRUPTED");
			}
	
			MessageDigest md;
			byte[] salt = new byte[12];
			System.arraycopy(storedPasswordBytesWithSalt, 0, salt, 0, 12);
			md = MessageDigest.getInstance(ALGO);
			md.update(salt);
			md.update(inputPassword.getBytes(CHARSET));
	
			byte[] digestForGivenPassword = md.digest();
			byte[] digestForExistingPassword = new byte[storedPasswordBytesWithSalt.length - 12];
			System.arraycopy(storedPasswordBytesWithSalt, 12, digestForExistingPassword, 0, storedPasswordBytesWithSalt.length - 12);
	
			boolean isMatching = Arrays.equals(digestForGivenPassword, digestForExistingPassword);
			return isMatching;
		}

}
