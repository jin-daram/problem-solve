import java.io.*;

public class BOJ_11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        int result = 0;

        for (int k=0; k<10; k++) {
            dp[1][k] = 1;
        }

        for (int i=2; i<=N; i++) {
            for (int k=9; k>=0; k--) {
                if (k == 9) dp[i][k] = dp[i-1][k] % 10007;
                else dp[i][k] = (dp[i-1][k] + dp[i][k+1]) % 10007;
            }
        }

        for (int i=0; i<10; i++) {
           result += dp[N][i];
        }

        System.out.println(result % 10007);
    }
}