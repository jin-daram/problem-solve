import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 1;
        if (N == 1) {
            System.out.println(dp[1]);
            return;
        }
        dp[2] = 2;
        if (N == 2) {
            System.out.println(dp[2]);
            return;
        }

        for (int i=3; i<=N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        System.out.println(dp[N]);
    }
}