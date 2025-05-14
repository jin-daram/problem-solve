import java.io.*;
import java.util.*;

public class BOJ_11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[N + 1];

        int[] money = new int[N + 1];
        for (int i=1; i<=N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=N; i++) {
            dp[i] = money[1] * i;
        }

        for(int i=2; i<=N; i++) {
            for (int k=1; k<=N; k++) {
                if (k == i) {
                    dp[k] = Math.max(dp[k], money[i]);
                }
                if (k+i <= N) {
                    dp[k+i] = Math.max(dp[k+i], dp[k] + money[i]);
                }
            }
        }
        System.out.println(dp[N]);
    }
}