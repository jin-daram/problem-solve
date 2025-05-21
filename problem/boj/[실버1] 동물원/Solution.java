import java.io.*;

public class BOJ_1309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[0] = 1;

        dp[1] = 3;
        if (N == 1) {
            System.out.println(dp[1]);
            return;
        }

        dp[2] = 7;
        if (N == 2) {
            System.out.println(dp[2]);
            return;
        }

        for (int i=3; i<=N; i++) {
            dp[i] = (2 * dp[i-1] + dp[i-2]) % 9901;
        }

        System.out.println(dp[N]);
    }

}
