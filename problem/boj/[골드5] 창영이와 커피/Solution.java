import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] C = new int[N];
        int[] dp = new int[K+1];

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }

        if (K == 0) {
            System.out.println(0);
            return;
        }

        int count = 0;
        for (int i=0; i<N; i++) {
            count = i;
            if (K >= C[i]) {
                dp[C[i]] = 1;
                break;
            }
        }

        for (int i=count+1; i<N; i++) {
            int target = C[i];
            for (int k=K; k>0; k--) {
                if (target == k && K >= target) {
                    dp[k] = 1;
                }
                if (dp[k] != 100001) {
                    if (k + target <= K) {
                        dp[k+target] = Math.min(dp[k] + 1, dp[k+target]);
                    }
                }
            }
        }

        if (dp[K] == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }

}
