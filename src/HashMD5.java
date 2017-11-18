import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMD5 {

    public HashMD5() {
    }

    public String hash(String str) {
        MessageDigest messDig;
        byte[] dig = new byte[0];

        try {
            messDig = MessageDigest.getInstance("MD5");
            messDig.reset();
            messDig.update(str.getBytes());
            dig = messDig.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        BigInteger big = new BigInteger(1, dig);
        String md5 = big.toString(16);
        while (md5.length() < 32) {
            md5 = "0" + md5;
        }

        return md5;
    }
}
