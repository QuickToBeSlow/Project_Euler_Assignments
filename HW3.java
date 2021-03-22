import java.math.BigInteger;
import java.util.Random;

public class HW3 {
    public static void main(String[] args) {
        //passes the desired bit length to generate a new RSA key.
        genRSA(4096);
    }

    private static void genRSA(int bitLength) {

        long time1 = System.currentTimeMillis();
        BigInteger p = BigInteger.probablePrime(bitLength, new Random());
        BigInteger q = BigInteger.probablePrime(bitLength, new Random());

        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)));
        BigInteger e = new BigInteger("3");
        while (!gcd(e, phi).equals(BigInteger.valueOf(1))) {
            e=e.add(BigInteger.valueOf(2));
        }
        BigInteger d = new BigInteger(getD(e, phi)+"");
        BigInteger m = new BigInteger("123456789");
        BigInteger r = m.modPow(e, n);
        BigInteger m2 = r.modPow(d, n);
        System.out.println("m: "+m);
        System.out.println("m2: "+m2);
        long time2 = System.currentTimeMillis();
        long timeTaken = time2-time1;
        System.out.println("Time taken in MS: "+timeTaken);
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        if (a.compareTo(b)<0)
            return gcd(b, a);

        if (b.compareTo(BigInteger.valueOf(0))==0)
            return a;

        return gcd(b, a.mod(b));
    }

    private static BigInteger getD(BigInteger e, BigInteger phi) {
        BigInteger u1 = new BigInteger("0");
        BigInteger u2 = new BigInteger(phi.toString());
        BigInteger v1 = new BigInteger("1");
        BigInteger v2 = new BigInteger(e.toString());

        while (!v2.equals(BigInteger.valueOf(0))) {
            BigInteger q = u2.divide(v2);
            BigInteger t1 = u1.subtract(q.multiply(v1));
            BigInteger t2 = u2.subtract(q.multiply(v2));

            u1 = v1;
            u2 = v2;

            v1 = t1;
            v2 = t2;
        }

        if (u1.compareTo(BigInteger.valueOf(0))<0) return u1.add(phi);
        else return u1;
    }
}
