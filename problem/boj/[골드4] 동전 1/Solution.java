import java.io.*;
import java.util.*;

public class BOJ_2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K+1];
        int[] coins = new int[N];

        for (int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        for (int i=1; i<=K; i++) {
            if (i % coins[0] == 0) {
                dp[i] = 1;
            }
        }
        for (int i=1; i<coins.length; i++) {
            int coin = coins[i];
            for (int k=coin; k<=K; k++) {
                if (k == coin) {
                    dp[k] = dp[k] + 1;
                } else {
                    dp[k] = dp[k] + dp[k-coin];
                }
            }
        }

        System.out.println(dp[K]);
    }
}
