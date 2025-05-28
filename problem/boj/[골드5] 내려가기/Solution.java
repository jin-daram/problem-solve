import java.io.*;
import java.util.*;

public class BOJ_2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][] dp = new int[N][3];
        int[][] minDp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int[] a : minDp) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];

        minDp[0][0] = map[0][0];
        minDp[0][1] = map[0][1];
        minDp[0][2] = map[0][2];

        for (int i = 1; i < N; i++) {
            for (int k = 0; k < 3; k++) {
                if (k == 0) {
                    dp[i][0] = Math.max(dp[i][0], dp[i - 1][k] + map[i][0]);
                    dp[i][1] = Math.max(dp[i][1], dp[i - 1][k] + map[i][1]);
                }

                if (k == 1) {
                    dp[i][0] = Math.max(dp[i][0], dp[i - 1][k] + map[i][0]);
                    dp[i][1] = Math.max(dp[i][1], dp[i - 1][k] + map[i][1]);
                    dp[i][2] = Math.max(dp[i][2], dp[i - 1][k] + map[i][2]);
                }

                if (k == 2) {
                    dp[i][1] = Math.max(dp[i][1], dp[i - 1][k] + map[i][1]);
                    dp[i][2] = Math.max(dp[i][2], dp[i - 1][k] + map[i][2]);
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int k = 0; k < 3; k++) {
                if (k == 0) {
                    minDp[i][0] = Math.min(minDp[i][0], minDp[i - 1][k] + map[i][0]);
                    minDp[i][1] = Math.min(minDp[i][1], minDp[i - 1][k] + map[i][1]);
                }

                if (k == 1) {
                    minDp[i][0] = Math.min(minDp[i][0], minDp[i - 1][k] + map[i][0]);
                    minDp[i][1] = Math.min(minDp[i][1], minDp[i - 1][k] + map[i][1]);
                    minDp[i][2] = Math.min(minDp[i][2], minDp[i - 1][k] + map[i][2]);
                }

                if (k == 2) {
                    minDp[i][1] = Math.min(minDp[i][1], minDp[i - 1][k] + map[i][1]);
                    minDp[i][2] = Math.min(minDp[i][2], minDp[i - 1][k] + map[i][2]);
                }
            }
        }

        int max = 0;
        int min = Integer.MAX_VALUE - 1;

        for (int i = 0; i < 3; i++) {
            max = Math.max(dp[dp.length - 1][i], max);
        }

        for (int i = 0; i < 3; i++) {
            min = Math.min(minDp[minDp.length - 1][i], min);
        }
        System.out.println(max + " " + min);
    }

}