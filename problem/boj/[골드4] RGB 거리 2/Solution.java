import java.io.*;
import java.util.*;

public class BOJ_17404 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][][] dp = new int[N][3][3];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<3; c++) {
                map[i][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0; i<N; i++) {
            for (int k=0; k<3; k++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][k][j] = 1000000;
                }
            }
        }

        for (int k=0; k<3; k++) {
            for (int j=0; j<3; j++) {
                dp[0][k][j] = map[0][k];
            }
        }

        for (int k=0; k<3; k++) {
            for (int j=0; j<3; j++) {
                if (k==0) {
                    dp[1][k][1] = Math.min(dp[1][k][1], map[0][1] + map[1][k]);
                    dp[1][k][2] = Math.min(dp[1][k][2], map[0][2] + map[1][k]);
                } else if (k==1) {
                    dp[1][k][0] = Math.min(dp[1][k][0], map[0][0] + map[1][k]);
                    dp[1][k][2] = Math.min(dp[1][k][2], map[0][2] + map[1][k]);
                } else {
                    dp[1][k][0] = Math.min(dp[1][k][0], map[0][0] + map[1][k]);
                    dp[1][k][1] = Math.min(dp[1][k][1], map[0][1] + map[1][k]);
                }
            }
        }

        for (int i=2; i<N; i++) {
            for (int k=0; k<3; k++) {
                if (k == 0) {
                    dp[i][k][0] = Math.min(dp[i-1][k+1][0] + map[i][k], dp[i-1][k+2][0] + map[i][k]);
                    dp[i][k][1] = Math.min(dp[i-1][k+1][1] + map[i][k], dp[i-1][k+2][1] + map[i][k]);
                    dp[i][k][2] = Math.min(dp[i-1][k+1][2] + map[i][k], dp[i-1][k+2][2] + map[i][k]);
                } else if (k == 1) {
                    dp[i][k][0] = Math.min(dp[i-1][k-1][0] + map[i][k], dp[i-1][k+1][0] + map[i][k]);
                    dp[i][k][1] = Math.min(dp[i-1][k-1][1] + map[i][k], dp[i-1][k+1][1] + map[i][k]);
                    dp[i][k][2] = Math.min(dp[i-1][k-1][2] + map[i][k], dp[i-1][k+1][2] + map[i][k]);
                } else { // k == 2
                    dp[i][k][0] = Math.min(dp[i-1][k-2][0] + map[i][k], dp[i-1][k-1][0] + map[i][k]);
                    dp[i][k][1] = Math.min(dp[i-1][k-2][1] + map[i][k], dp[i-1][k-1][1] + map[i][k]);
                    dp[i][k][2] = Math.min(dp[i-1][k-2][2] + map[i][k], dp[i-1][k-1][2] + map[i][k]);
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int k=0; k<3; k++) {
            if (k == 0) {
                result = Math.min(dp[N-1][k][1], result);
                result = Math.min(dp[N-1][k][2], result);
            } else if (k == 1) {
                result = Math.min(dp[N-1][k][0], result);
                result = Math.min(dp[N-1][k][2], result);
            } else {
                result = Math.min(dp[N-1][k][0], result);
                result = Math.min(dp[N-1][k][1], result);
            }
        }

        System.out.println(result);
    }

}
