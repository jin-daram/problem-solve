import java.io.*;
import java.util.*;

public class BOJ_11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        int[] dp = new int[N];
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = numbers[0];

        for (int i=0; i<N; i++) {
            int targetNumber = numbers[i];
            for (int k=0; k<i; k++) {
                if (targetNumber > numbers[k]) dp[i] = Math.max(dp[i] , targetNumber + dp[k]);
                else dp[i] = Math.max(dp[i], targetNumber);
            }
        }

        int result = 0;
        for (Integer element : dp) {
            result = Math.max(result, element);
        }
        System.out.println(result);
    }
}