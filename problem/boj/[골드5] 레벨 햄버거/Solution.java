import java.io.*;
import java.util.*;

public class BOJ_16974 {

    public static long[] dp;
    public static long[] layers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        dp = new long[N+1];
        layers = new long[N+1];
        dp[0] = 1;
        layers[0] = 1;

        for (int i=1; i<=N; i++) {
            dp[i] = dp[i-1] + 1 + dp[i-1];
            layers[i] = 1 + layers[i-1] + 1 + layers[i-1] + 1;
        }

        if (X <= N) {
            System.out.println(0);
            return;
        }

        long result = recursive(N, X);
        System.out.println(result);
    }

    public static long recursive(int N, long X) {
        // 가운데 패티까지 먹는 경우 (layer / 2) + 1
        if (X <= N) return 0;
        if (N == 0) return 1;

        if ((layers[N] / 2) + 1 > X) { // 왼쪽 패티
            return recursive(N-1, X-1);
        } else if ((layers[N] / 2) + 1 == X) { // 가운데 패티까지
            return dp[N-1] + 1;
        } else { // 오른쪽 패티까지
            return dp[N-1] + 1 + recursive(N-1, X - layers[N-1] - 2);
        }

    }

}