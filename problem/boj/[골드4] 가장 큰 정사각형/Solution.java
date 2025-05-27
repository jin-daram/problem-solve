import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int k=0; k<M; k++) {
                map[i][k] = line.charAt(k) - '0';
            }
        }

        int result = 0;

        for (int i=0; i<M; i++) {
            if (map[0][i] == 1) {
                dp[0][i] = 1;
                result = 1;
            }
        }

        for (int i=0; i<N; i++) {
            if (map[i][0] == 1) {
                dp[i][0] = 1;
                result = 1;
            }
        }

        for (int i=1; i<N; i++) {
            for (int k=1; k<M; k++) {
                if (map[i][k] == 1) {
                    if (map[i-1][k] == 1 && map[i][k-1] == 1 && map[i-1][k-1] == 1) {
                        dp[i][k] = Math.min(Math.min(dp[i-1][k], dp[i][k-1]), dp[i-1][k-1]) + 1;
                    } else {
                        dp[i][k] = 1;
                    }
                    result = Math.max(result, dp[i][k]);
                }
            }
        }

        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }

        System.out.println(result * result);
    }
}