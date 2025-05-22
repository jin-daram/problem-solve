import java.io.*;
import java.util.*;

public class BOJ_11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        int[][] inputs = new int[M][4]; // x1,y1,x2,y2 순서
        int[][] dp = new int[N+1][N+1];
        List<Integer> results = new ArrayList<>();

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k=1; k<=N; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int k=0; k<4; k++) {
                inputs[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = map[1][1];

        // 가로축
        for (int i=2; i<=N; i++) {
            dp[1][i] = dp[1][i-1] + map[1][i];
        }

        // 세로축
        for (int i=2; i<=N; i++) {
            dp[i][1] = dp[i-1][1] + map[i][1];
        }

        for (int i=2; i<=N; i++) {
            for (int k=2; k<=N; k++) {
                dp[i][k] = (dp[i-1][k] + dp[i][k-1]) - dp[i-1][k-1] + map[i][k];
            }
        }

        for (int[] a : inputs)  {
            int x1 = a[0];
            int y1 = a[1];
            int x2 = a[2];
            int y2 = a[3];

            int result = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
            results.add(result);
        }

        for(Integer result : results) {
            System.out.println(result);
        }

    }

}
