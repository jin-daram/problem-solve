import java.io.*;
import java.util.*;

public class BOJ_15989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 10001;
        int[] dp = new int[N+1];

        for (int i=1; i<=N; i++) {
            dp[i] = 1;
        }

        int start = 2;
        for (int i=start; i<=3; i++) {
            for(int k=i; k<=N; k++) {
                if (k==i) dp[k] = dp[k] + 1;
                else dp[k] = dp[k] + (dp[k-start]);
            }
            start += 1;
        }
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(dp[a]);
        }
    }
}