import java.io.*;
import java.util.*;

public class BOJ_1106 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 얻어야 하는 고객
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수

        int[] dp = new int[C+1]; // dp[n]은 n명을 유치하려고 할 때, 드는 비용
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int[][] info = new int[N][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken()); // 비용
            info[i][1] = Integer.parseInt(st.nextToken()); // 얻은 고객 수
        }

        for (int k=0; k<info.length; k++) {
            int price = info[k][0];
            int people = info[k][1];
            for (int i=1; i<C+1; i++) {
                dp[i] = i % people == 0 ? Math.min(dp[i], price * (i/people)) : Math.min(dp[i], price * (i/people + 1));
                if (i - people >= 1) {
                    dp[i] = Math.min(dp[i-people] + price, dp[i]);
                }
            }
        }
        System.out.println(dp[C]);
    }
}