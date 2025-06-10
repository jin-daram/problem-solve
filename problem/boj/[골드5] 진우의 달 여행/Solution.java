import java.io.*;
import java.util.*;

public class BOJ_17485 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][][] dp = new int[N][M][3];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k=0; k<M; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<N; i++) {
            for (int k=0; k<M; k++) {
                for (int dir=0; dir<3; dir++) {
                    dp[i][k][dir] = 1000000;
                }
            }
        }

        for (int k=0; k<M; k++) {
            for (int dir=0; dir<3; dir++) {
                dp[0][k][dir] = map[0][k];
            }
        }

        for (int k=0; k<M; k++) {
            if (k==0) {
                dp[1][k][1] = map[0][k] + map[1][k];
                dp[1][k][0] = map[0][k+1] + map[1][k];
            } else if (k == M -1) {
                dp[1][k][1] = map[0][k] + map[1][k];
                dp[1][k][2] = map[0][k-1] + map[1][k];
            } else {
                dp[1][k][0] = map[0][k+1] + map[1][k];
                dp[1][k][1] = map[0][k] + map[1][k];
                dp[1][k][2] = map[0][k-1] + map[1][k];
            }
        }

        for (int i=2; i<N; i++) {
            for (int k=0; k<M; k++) {
                if (k==0) {
                    dp[i][k][0] = Math.min(dp[i-1][k+1][1] + map[i][k], dp[i-1][k+1][2] + map[i][k]);
                    dp[i][k][1] = Math.min(dp[i-1][k][0] + map[i][k], dp[i][k][1]);
                } else if (k == M-1) {
                    dp[i][k][1] = Math.min(dp[i-1][k][2] + map[i][k], dp[i][k][1]);
                    dp[i][k][2] = Math.min(dp[i-1][k-1][1] + map[i][k], dp[i-1][k-1][0] + map[i][k]);
                } else {
                    dp[i][k][0] = Math.min(dp[i-1][k+1][1] + map[i][k], dp[i-1][k+1][2] + map[i][k]);
                    dp[i][k][1] = Math.min(dp[i-1][k][0] + map[i][k], dp[i-1][k][2] + map[i][k]);
                    dp[i][k][2] = Math.min(dp[i-1][k-1][0] + map[i][k], dp[i-1][k-1][1] + map[i][k]);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int k=0; k<M; k++) {
            for (int dir=0; dir<3; dir++) {
                if (dp[N-1][k][dir] != 0) {
                    result = Math.min(result, dp[N-1][k][dir]);
                }
            }
        }
        System.out.println(result);
    }
}