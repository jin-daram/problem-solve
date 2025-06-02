import java.io.*;
import java.util.*;

// 백준 회사 문화 1
public class BOJ_14267 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사원 수
        int M = Integer.parseInt(st.nextToken()); // 최초 칭찬 개수

        int[] directCaptain = new int[100001]; // index: 직원 번호 value: 직속 상사

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            directCaptain[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        dp[1] = 0;

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int employee = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            dp[employee] += value;
        }

        for (int i=2; i<=N; i++) {
            dp[i] = dp[directCaptain[i]] + dp[i];
        }

        StringBuilder result = new StringBuilder();
        for (int i=1; i<=N; i++) {
            if (i == N) {
                result.append(dp[i]);
            } else {
                result.append(dp[i] + " ");
            }
        }
        System.out.println(result);
    }
}