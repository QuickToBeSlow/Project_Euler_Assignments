

public class Problem4 {
    public static void main(String[] args) {
        findLargestPalindrome(999);
    }

    private static void findLargestPalindrome(int max) {

        int lp=0; //Largest palindrome

        for (int i=1; i<max+1; i++) {
            for (int j=1; j<max+1; j++) {

                String s = String.valueOf(i*j);
                int l=s.length()-1;
//                System.out.println(l);
                boolean isLP = true;

                for (int k=0; k<s.length()/2; k++) {
                    if (s.charAt(k)!=(s.charAt(l-k))) {
                        isLP=false;
                        break;
                    }
                }
                if (isLP && lp<i*j) {
                    lp=i*j;
                }

            }
        }

        System.out.println(lp);
    }
}
