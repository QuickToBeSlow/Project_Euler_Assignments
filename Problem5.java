

public class Problem5 {

    public static void main(String[] args) {
        smallestDivisor(20);
    }

    private static void smallestDivisor(int max) {
        //Since we know all numbers must be divisible by 2520, we'll increment by 2520 until we get the desired answer.
        final int incBy = 2520;
        boolean foundVal = false;
        int num = 0;

        while (!foundVal) {
            num+=incBy;
            foundVal=true;
            for (int i=0; i<max-10; i++) {
                if (num%(max-i)!=0) {
                    foundVal=false;
                    break;
                }
            }
        }
        System.out.println(num);
    }
}
