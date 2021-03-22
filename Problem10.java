import java.util.ArrayList;

public class Problem10 {
    public static void main(String[] args) {
        findPrimeSums(2000000);
    }
    private static void findPrimeSums(int maxNum) {
        ArrayList<Integer> primes=new ArrayList<>();
        primes.add(2);
        primes.add(3);
        int pos=5;
        int arrayPos=0;
        int primesFound=2;
        while (pos<maxNum) {
            arrayPos=0;
            do {
                arrayPos++;//start from the second prime (since they'll all be odd numbers).
                if (primes.size() <= arrayPos) {
                    primes.add(pos);
                    primesFound++;
                }
            } while (pos % primes.get(arrayPos) != 0);
            pos+=2;
        }
        long sum=0;
        for (Integer p : primes) {
            sum += p;
        }
        System.out.println(sum);
    }

}
