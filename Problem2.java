

public class Problem2 {
    public static void main(String[] args) {
        fibUntil(4000000);
    }
    private static void fibUntil(int m) {
        //tp = the previous term, tc = the current term.
        int tp = 1;
        int tc = 2;
        int hold = 0;
        int sum = tc;

        while(tc<=m) {
            hold = tc;
            tc += tp;
            tp = hold;
            if (tc%2==0)
                sum+=tc;
        }
        System.out.println(sum);
    }
}
