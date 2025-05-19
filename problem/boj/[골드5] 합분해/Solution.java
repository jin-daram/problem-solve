import java.io.*;
import java.util.*;

public class BOJ_2225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N+1][K+1];
        long[][] result = new long[N+1][K+1];

        for(int i=0; i<=N; i++) {
            dp[i][1] = 1;
            result[i][1] = i == 0 ? 1 : result[i-1][1] + 1;
        }

        for (int k=2; k<=K; k++) {
            for (int i=0; i<=N; i++) {
                dp[i][k] = result[i][k - 1] % 1000000000;
                result[i][k] = i == 0 ? (result[i][k - 1]) % 1000000000 : result[i - 1][k] + dp[i][k] % 1000000000;
            }
        }
        System.out.println(dp[N][K] % 1000000000);
    }
}
