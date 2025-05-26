import java.io.*;
import java.util.*;

public class BOJ_10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N+1];
        int[][] dp = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = 1;
        }

        for (int i=2; i<=N; i++) {
            if (numbers[i-1] == numbers[i]) dp[i-1][i] = 1;
        }

        for (int i=3; i<=N; i++) {
            int back = -(i - 1);
            for (int k=i; k<=N; k++) {
                int start = k + back;
                int end = k;
                if (numbers[start] == numbers[end])
                    if (dp[start + 1][end - 1] == 1)
                        dp[start][end] = 1;
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e]).append("\n");
        }
        System.out.println(sb);
    }
}