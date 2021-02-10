import java.math.BigInteger;

public class Problem16 {
    public static void main(String[] args) {
        sumOfDigits(1000);
    }

    private static void sumOfDigits(int pow) {
        BigInteger num = BigInteger.valueOf(2);
        num = num.pow(pow);
        String numString = num.toString();
        int numDigitSum = 0;
        for (int i=0; i<numString.length(); i++) {
            numDigitSum+=Integer.parseInt(String.valueOf(numString.charAt(i)));
        }
        System.out.println(numDigitSum);
    }
}
