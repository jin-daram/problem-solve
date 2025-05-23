import java.io.*;
import java.util.*;

public class BOJ_9251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        int[][] dp = new int[second.length()][first.length()];
        boolean flag = false;

        for (int i=0; i<first.length(); i++) {
            if (second.charAt(0) == first.charAt(i)) {
                flag = true;
                dp[0][i] = 1;
            } else if (flag) {
                dp[0][i] = 1;
            }
        }

        for (int i=1; i<second.length(); i++) {
            char target = second.charAt(i);
            for (int k=0; k<first.length(); k++) {
                if (k == 0) {
                    int result = target == first.charAt(k) ? 1 : 0;
                    dp[i][k] = Math.max(dp[i-1][k], result);
                    continue;
                }

                if (target == first.charAt(k)) {
                    dp[i][k] = dp[i-1][k-1] + 1;
                } else {
                    dp[i][k] = Math.max(dp[i][k-1], dp[i-1][k]);
                }
            }
        }

        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println(dp[second.length() -1][first.length() -1]);
    }

}
