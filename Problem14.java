public class Problem14 {
    public static void main(String[] args) {
        getLongestCollatz(1000000);
    }
    private static void getLongestCollatz(int m) {
        int l=0;
        int mi = 0;
        for (int i=1; i<m; i++) {
            int c=0;
            double v=i;
            while (v!=1) {
                c++;
                v=(v%2==0) ? (v/2) : (3*v+1);
            }
            if (c>l) {
                l=c;
                mi=i;
            }
        }
        System.out.println(mi);
    }
}
