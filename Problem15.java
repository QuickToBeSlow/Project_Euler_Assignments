import java.util.Arrays;

public class Problem15 {
    public static void main(String[] args) {
        numLatticePaths(20);
    }
    private static void numLatticePaths(int length) {
        length=length*2+1;
        long[][] arr = new long[(int) length][];

        for (int i=0; i<length; i++) {
            arr[i] = new long[i+1];
        }
        arr[0][0]=1;
        for (int i=1; i<length; i++) {
            for (int j=0; j<i+1; j++) {
                if (j==0) {
                    arr[i][j]=1;
                } else if (j<i) {
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                } else {
                    arr[i][j]=arr[i-1][j-1];
                }
            }
        }
        long ans=arr[length-1][(length-1)/2];
        for (int i=0; i<length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        System.out.println(ans);
    }
}
