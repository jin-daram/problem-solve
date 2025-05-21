import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 0;
        if (N == 1) {
            System.out.println(dp[N]);
            return;
        }

        dp[2] = 3;
        if (N == 2) {
            System.out.println(dp[N]);
            return;
        }

        dp[3] = 0;
        if (N == 3) {
            System.out.println(dp[N]);
            return;
        }

        for (int i=4; i<=N; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i-2] * 3;
                for (int k=i-4; k>=0; k--) {
                    dp[i] += (dp[k] * 2);
                }
            } else {
                dp[i] = 0;
            }
        }
        System.out.println(dp[N]);
    }
}