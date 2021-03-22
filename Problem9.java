public class Problem9 {
    public static void main(String[] args) {
        findTriplet(1000);
    }

    private static void findTriplet(int sum) {
        double a=0, b=0, c=0;
        boolean foundTriplet=false;
        while (!foundTriplet && a<sum) {
            b++;
            a=1;
            while (a<b+1) {
                c=Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
                if ((int)(a+b+c)==sum && c%1==0) {
                    foundTriplet=true;
                    break;
                }
                a++;
            }
        }
        System.out.println(a*b*c);
    }
}
