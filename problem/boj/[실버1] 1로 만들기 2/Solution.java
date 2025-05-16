import java.io.*;
import java.util.*;

public class BOJ_12852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[] way = new int[N+1];

        dp[1] = 0;

        if (N >= 2) dp[2] = 1;
        if (N >= 3) dp[3] = 1;
        if (N > 3) {
            for (int i=4; i<=N; i++) {
                dp[i] = Math.min(dp[i], dp[i-1] + 1);
                way[i] = 1;
                if (i%2 == 0) {
                    dp[i] = Math.min(dp[i], dp[i/2] + 1);
                    if (dp[i] == dp[i/2] + 1) way[i] = 2;
                }
                if (i%3 == 0) {
                    dp[i] = Math.min(dp[i], dp[i/3] + 1);
                    if (dp[i] == dp[i/3] + 1) way[i] = 3;
                }
            }
        }

        System.out.println(dp[N]);
        StringBuilder temp = new StringBuilder();
        int tempNumber = N;
        for (int i=0; i<dp[N]; i++) {
            temp.append(tempNumber + " ");
            if (way[tempNumber] == 1) tempNumber = tempNumber - 1;
            else if (way[tempNumber] == 2) tempNumber = tempNumber / 2;
            else tempNumber = tempNumber/3;
        }
        System.out.println(N == 1 ? "1" : temp.toString() + "1");
    }
}