import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k=1; k<=M; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = map[1][1];

        for (int i=2; i<=N; i++) {
            dp[i][1] = dp[i-1][1] + map[i][1];
        }

        for (int i=2; i<=M; i++) {
            dp[1][i] = dp[1][i-1] + map[1][i];
        }

        for (int i=2; i<=N; i++) {
            for (int k=2; k<=M; k++) {
                int currentCandy = map[i][k];
                dp[i][k] = currentCandy + dp[i-1][k-1];
                dp[i][k] = Math.max(dp[i][k], currentCandy + dp[i-1][k] );
                dp[i][k] = Math.max(dp[i][k], currentCandy + dp[i][k-1]);
            }
        }
        System.out.println(dp[N][M]);
    }
}
