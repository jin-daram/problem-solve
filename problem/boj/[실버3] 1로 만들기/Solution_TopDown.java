import java.io.*;
import java.util.*;

public class BOJ_1463 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, -1);

        System.out.println(topDown(N));
    }

    public static int topDown(int N) {
        if (N == 1) return 0;
        if (dp[N] != -1) return dp[N];

        int res = dp(N - 1) + 1;
        if (N % 2 == 0) res = Math.min(res, topDown(N / 2) + 1);
        if (N % 3 == 0) res = Math.min(res, topDown(N / 3) + 1);

        return dp[N] = res;
    }
}