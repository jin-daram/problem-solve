import java.io.*;
import java.util.*;

public class BOJ_2631 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        int[] dp = new int[N];

        for (int i=0; i<N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        dp[0] = 1;

        for (int i=1; i<N; i++) {
            for (int k=0; k<i; k++) {
                if (arr.get(k) < arr.get(i)) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
        }

        int max = 0;
        for (int i=0; i<N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(N - max);
    }
}