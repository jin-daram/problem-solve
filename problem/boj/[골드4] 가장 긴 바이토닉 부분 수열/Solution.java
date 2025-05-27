import java.io.*;
import java.util.*;

public class BOJ_11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        int[][] dp = new int[2][N];
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(1);
            return;
        }

        dp[0][0] = 1; // dp[0]은 상승
        dp[1][0] = 1; // dp[1]은 하강

        if (numbers[0] > numbers[1]) {
            dp[0][1] = 1;
            dp[1][1] = 2;
        } else if (numbers[0] == numbers[1]) {
            dp[0][1] = 1;
            dp[1][1] = 1;
        } else {
            dp[0][1] = 2;
            dp[1][1] = 2;
        }


        for (int i=2; i<N; i++) {
            int target = numbers[i];
            dp[0][i] = 1;
            dp[1][i] = 1;
            for (int k=0; k<i; k++) {
                if (target > numbers[k]) {
                    dp[0][i] = Math.max(dp[0][i], dp[0][k] + 1);
                }

                if (target < numbers[k]) {
                    dp[1][i] = Math.max(dp[1][i], dp[1][k] + 1);
                    dp[1][i] = Math.max(dp[1][i], dp[0][k] + 1);
                }
            }
        }
        int result = 0;

        for (int i=0; i<2; i++) {
            for (int k=0; k<N; k++) {
                result = Math.max(result, dp[i][k]);
            }
        }
        System.out.println(result);
    }
}