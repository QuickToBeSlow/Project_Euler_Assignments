public class Problem7 {
    public static void main(String[] args) {
        findPrime(10001);
    }
    private static void findPrime(int primeNum) {
        int[] primes=new int[primeNum];
        primes[0]=2;
        primes[1]=3;
        int pos=5;
        int arrayPos=0;
        int primesFound=2;
        while (primesFound<primeNum) {
            arrayPos=0;
            do {
                arrayPos++;//start from the second prime (since they'll all be odd numbers).
                if (primes[arrayPos] == 0) {
                    primes[arrayPos] = pos;
                    primesFound++;
                }
            } while (pos % primes[arrayPos] != 0);
            pos+=2;
        }
        System.out.println(primes[primeNum-1]);
    }
}
