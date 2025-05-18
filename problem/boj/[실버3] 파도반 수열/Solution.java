import java.io.*;
import java.util.*;

public class BOJ_9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        List<Long> results = new ArrayList<>();
        long[] dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i=6; i<dp.length; i++) dp[i] = dp[i-1] + dp[i-5];

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            results.add(dp[N]);
        }

        for (Long result : results)
            System.out.println(result);
    }

}
