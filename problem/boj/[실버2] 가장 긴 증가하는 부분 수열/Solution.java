import java.io.*;
import java.util.*;

public class BOJ_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int[] arr = new int[A];
        int[] dp = new int[A];

        for (int i=0; i<A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i]는 i번째 기준 만들 수 있는 부분수열의 최대 길이
        dp[0] = 1;

        for (int i=1; i<A; i++) {
            dp[i] = 1;
            for (int k=0; k<i; k++) {
                if (arr[k] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[k]+1);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);
    }
}