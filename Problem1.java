
public class Problem1 {
    public static void main(String[] args) {
        int nums[] = {3, 5};
        int max = 1000;

        int sum = findMultiples(nums, max);

        displayResults(sum);
    }

    private static int findMultiples(int[] nums, int m) {
        int sum = 0;
        for (int i=1; i<m; i++) {
            for (int a : nums) {
                if (i%a==0) {
                    sum+=i;
                    break;
                }
            }
        }
        return sum;
    }

    private static void displayResults(int sum) {
        System.out.println(sum);
    }
}
