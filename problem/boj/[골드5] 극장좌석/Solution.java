import java.io.*;

public class BOJ_2302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int vipCount = Integer.parseInt(br.readLine());
        boolean[] vips = new boolean[41];
        long[] dp = new long[41];

        for (int i=0; i<vipCount; i++) {
            vips[Integer.parseInt(br.readLine())] = true;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i=4; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int count = 0;
        long result = 1;
        for (int i=1; i<=N; i++) {
            if (vips[i]) {
                result *= dp[count];
                count = 0;
                continue;
            }
            count += 1;
        }
        result *= dp[count];

        System.out.println(result);
    }
}