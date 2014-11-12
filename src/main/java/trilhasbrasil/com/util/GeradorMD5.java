package trilhasbrasil.com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class GeradorMD5 {

	public static String gerarMD5(String pass) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("md5");
		md.update(pass.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}
	
}
