

public class Problem6 {
    public static void main(String[] args) {
        int num = 100;
        int answer = sumOfSquares(num) - squareOfSums(num);
        System.out.println(sumOfSquares(num));
        System.out.println(squareOfSums(num));
        System.out.println(answer);
    }

    private static int squareOfSums(double num) {
        int sum = (int)(num*(num+1)/2);
        sum=sum*sum;
        return sum;
    }

    private static int sumOfSquares(int num) {
        int sum = 0;
        for (int i=1; i<num+1; i++) {
            sum+=i*i;
        }
        return sum;
    }
}
