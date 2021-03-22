import java.util.Arrays;
import java.util.Comparator;

public class Problem68 {
    public static void main(String[] args) throws InterruptedException {
        maxFiveGon();
    }

    /**
     * Calculates the maximum 16-digit number gained from combining, from least to greatest, the values of each line of nodes.
     */
    static void maxFiveGon() throws InterruptedException {
        int gonSize = 5;
        int size=gonSize*2;
        int targetSum = ((2*(1+gonSize)/2*gonSize)+((1+gonSize+size)/2*gonSize))/gonSize;
        int[] nodeVals;
        int[] bestGon = new int[0];
        int[][] validSegs = new int[0][];
        long bestGonInt=0;
        //Welcome to For Loop Hell.
        //(I'm realizing just brute forcing this would've worked just as well.)
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (j==i)
                    continue;
                for (int k=0; k<size; k++) {
                    if (k==j || k==i)
                        continue;
                    for (int l=0; l<size; l++) {
                        if (l==k || l==j || l==i)
                            continue;
                        for (int m=0; m<size; m++) {
                            if (m == l || m == k || m == j || m == i)
                                continue;
                            for (int n = 0; n < size; n++) {
                                if (n == m || n == l || n == k || n == j || n == i)
                                    continue;
                                boolean validGon = true;
                                int[] valTallies = new int[size];
                                nodeVals=new int[10];
                                nodeVals[0] = i + 1;
                                nodeVals[3] = j + 1;
                                nodeVals[5] = k + 1;
                                nodeVals[7] = l + 1;
                                nodeVals[9] = m + 1;
                                for (int o = 0; o < gonSize; o++) {
                                    if (o == n || o == m || o == l || o == k || o == j || o == i)
                                        continue;
                                    nodeVals[1] = o + 1;
                                    for (int p = 0; p < size; p += 2) {
                                        nodeVals[(p + 2) % (size - 1)] = targetSum - nodeVals[p] - nodeVals[p + 1];
                                        if (nodeVals[(p + 2) % (size - 1)] > size || nodeVals[(p + 2) % (size - 1)] < 1) {
                                            validGon = false;
                                            break;
                                        }
                                        if (p==size-2 && nodeVals[(p + 2) % (size - 1)] != o + 1) {
                                            validGon = false;
                                            break;
                                        }
                                        int[] valPos = new int[]{0, 3, 5, 7, 9};
                                        for (int q=0; q<gonSize; q++) {
                                            if (nodeVals[(p + 2) % (size - 1)]==nodeVals[valPos[q]]) {
                                                validGon = false;
                                                break;
                                            }
                                        }
                                        valTallies[(p + 2) % (size - 1)]++;
                                        if (valTallies[(p + 2) % (size - 1)] > 1) {
                                            validGon = false;
                                            break;
                                        }
                                    }
                                    if (validGon) {
                                        int[][] nodeSegments = new int[][]{
                                                {nodeVals[0],nodeVals[1],nodeVals[2]},
                                                {nodeVals[3],nodeVals[2],nodeVals[4]},
                                                {nodeVals[5],nodeVals[4],nodeVals[6]},
                                                {nodeVals[7],nodeVals[6],nodeVals[8]},
                                                {nodeVals[9],nodeVals[8],nodeVals[1]},
                                        };
//                                        for (int q=0; q<nodeSegments.length; q++) {
//                                            System.out.println(Arrays.toString(nodeSegments[q]));
//                                        }
                                        Arrays.sort(nodeSegments, Comparator.comparingDouble(a -> a[0]));
//                                        System.out.println(Arrays.toString(nodeVals));
//                                        Thread.sleep(3000);
                                        StringBuilder strTestGon = new StringBuilder();
                                        for (int[] val : nodeSegments) {
                                            for (int v : val) {
                                                strTestGon.append(v);
                                            }
                                        }
                                        long testGon = Long.parseLong(String.valueOf(strTestGon));
                                        if (testGon > bestGonInt) {
                                            validSegs=new int[gonSize][3];
                                            validSegs[0]=nodeSegments[0].clone();
                                            for (int q=0; q<gonSize-1; q++) {
                                                int[] targetSeg;
                                                for (int r=0; r<gonSize; r++) {
                                                    if (validSegs[q][2]==nodeSegments[r][1]) {
                                                        validSegs[q+1]=nodeSegments[r].clone();
                                                        break;
                                                    }
                                                }
                                            }
                                            bestGon = nodeVals.clone();
                                            bestGonInt = testGon;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
//        System.out.println(bestGonInt);
//        System.out.println(Arrays.toString(bestGon));
        for (int i=0; i<gonSize; i++)
        System.out.println(Arrays.toString(validSegs[i]));
    }
}
