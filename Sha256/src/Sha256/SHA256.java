package Sha256;

import java.util.*;
import java.util.concurrent.TimeUnit;

class SHA256{
	
	public static void main(String args[]) {
		  Scanner sc= new Scanner(System.in); 
		  System.out.println("Enter Message: ");
		  String text= sc.nextLine();
		  sc.close();
          long startTime = System.nanoTime();
		  String hash = sha256(text);
	      long endTime = System.nanoTime();
		  System.out.println("Hash of '" + text + "' : " + hash);
	      long timeElapsed = endTime - startTime;
	      System.out.println("Execution time (nanosec) : " + timeElapsed);
	}
	
	public static String sha256(String data) {
		try{
			Sha256Digest digest = Sha256Digest.getInstance("SHA-256");
			byte[] hash = digest.digest(data.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1)
			    hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
}