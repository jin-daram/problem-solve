import java.io.*;
import java.util.*;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] numbers = new int[]{3,5};
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i=0; i<2; i++) {
            int number = numbers[i];
            for (int k=number; k<=N; k++) {
                if (dp[k-number] != Integer.MAX_VALUE) dp[k] = Math.min(dp[k], dp[k-number] + 1);
            }
        }

        if (dp[N] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[N]);
    }
}