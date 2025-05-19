import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int answer = numbers[N-1];

        long[][] dp = new long[N+1][21];

        dp[1][numbers[0]] = 1;

        for (int i=2; i<=N-1; i++) {
            int number =  numbers[i-1];
            for (int k=0; k<=20; k++) {
                if (dp[i-1][k] != 0) {
                    if (k + number <= 20)
                        dp[i][k+number] += dp[i-1][k];
                    if (k - number >= 0) {
                        dp[i][k-number] += dp[i-1][k];
                    }
                }
            }
        }
        System.out.println(dp[N-1][answer]);
    }
}