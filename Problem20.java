import java.math.BigInteger;

public class Problem20 {
    public static void main(String[] args) {
        factorialDigitSum(100);
    }
    private static void factorialDigitSum(int num) {
        BigInteger factorial = BigInteger.valueOf(num);
        for (int i=1; i<num; i++) {
            factorial=factorial.multiply(BigInteger.valueOf(num-i));
        }
        String digits = factorial.toString();
        int sum = 0;
        for (int i=1; i<digits.length(); i++) {
            sum+=Integer.parseInt(digits.substring(i-1,i));
        }
        System.out.println(sum);
    }
}
