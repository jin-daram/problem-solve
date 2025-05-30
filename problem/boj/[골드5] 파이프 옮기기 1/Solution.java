import java.io.*;
import java.util.*;

public class BOJ_17070 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        int[][][] dp = new int[N+1][N+1][3];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k=1; k<=N; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=2; i<=N; i++) {
            if (map[1][i] == 1) break;
            dp[1][i][0] = 1;

        }

        for (int i=2; i<=N; i++) {
            for (int k=2; k<=N; k++) {
                if (map[i][k] != 1) {
                    if (map[i-1][k-1] != 1 && map[i][k-1] != 1 && map[i-1][k] != 1) {
                        dp[i][k][2] += dp[i-1][k-1][0] + dp[i-1][k-1][1] + dp[i-1][k-1][2];
                    }

                    if (map[i-1][k] != 1) {
                        dp[i][k][1] += dp[i-1][k][2] + dp[i-1][k][1];
                    }

                    if (map[i][k-1] != 1) {
                        dp[i][k][0] += dp[i][k-1][2] + dp[i][k-1][0];
                    }
                }
            }
        }
        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }
}