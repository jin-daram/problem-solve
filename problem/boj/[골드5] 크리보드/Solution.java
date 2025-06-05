import java.io.*;

public class BOJ_11058 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];

        if (N < 7) {
            System.out.println(N);
            return;
        }

        for (int i=1; i<=6; i++) {
            dp[i] = i;
        }

        for (int i=7; i<=N; i++) {
            for (int k=3; k<i; k++) {
                dp[i] = Math.max(dp[i], dp[i-k] * (k-1));
            }
        }

        System.out.println(dp[N]);
    }
}
