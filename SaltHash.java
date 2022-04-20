import java.math.BigInteger;  
import java.security.NoSuchAlgorithmException;  
import java.security.NoSuchProviderException;  
import java.security.MessageDigest;  
import java.security.SecureRandom;  
  
  
public class MD5SaltedExample   
{  
public static byte[] receiveSalt() throws NoSuchAlgorithmException  
{  
SecureRandom secRand = SecureRandom.getInstance("SHA1PRNG");  
  
// Create an array for the salt  
byte[] s = new byte[15];  
// Get the random salt  
secRand.nextBytes(s);  
  
//return the salt  
return s;  
}  
  
// getting the hash value of the password using MD5 alogrithm and salt array  
private static String getSecurePswd(String psdToHash, byte[] saltArr)  
{  
// For storing the hash of the password  
String generatedPswd = null;  
try   
{  
// Creating an instance of MessageDigest for MD5  
MessageDigest msgDigest = MessageDigest.getInstance("MD5");  
  
// Add password b to digest  
msgDigest.update(saltArr);  
  
// Get the hash bytes   
byte[] b = msgDigest.digest(psdToHash.getBytes());  
  
// This b[] contains bytes in the decimal format;  
// Converting it to the hexadecimal format  
StringBuilder sbObj = new StringBuilder();  
  
for(int i = 0; i < b.length ; i++)  
{  
sbObj.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));  
}  
// Get the complete hashed password in the hex format  
generatedPswd = sbObj.toString();  
}   
  
// handling the exception  
catch (NoSuchAlgorithmException obj)   
{  
obj.printStackTrace();  
}  
  
return generatedPswd;  
}  
// main method  
public static void main(String argvs[]) throws NoSuchProviderException, NoSuchAlgorithmException  
{  
String str = "JavaTpoint"; // string to be hashed   
byte[] saltArr = receiveSalt();  
   
String securePsd = getSecurePswd(str, saltArr);  
System.out.println("The HashCode Generated for " + str + " is: " + securePsd);  
String regeneratedPswdToVerify = getSecurePswd(str, saltArr);  
System.out.println("The HashCode Generated for " + str + " is: " + securePsd);  
}  
}  