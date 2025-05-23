import java.io.*;
import java.util.*;

public class BOJ_1256 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[M + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i <= M; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= M; i++) {
            for (int k = 1; k <= N; k++) {
                dp[i][k] = Math.min(1_000_000_001L, dp[i - 1][k] + dp[i][k - 1]);
            }
        }

        StringBuilder result = new StringBuilder();

        int a = N;
        int z = M;

        if (dp[z][a] < K) {
            System.out.println(-1);
            return;
        }

        while (result.length() != N + M) {
            if (a == 0 || z == 0) {
                if (a == 0) {
                    for (int i=0; i<z; i++) {
                        result.append("z");
                    }
                } else {
                    for (int i=0; i<a; i++) {
                        result.append("a");
                    }
                }
                break;
            } else if (z == 1 && a == 1) {
                if (K == 2) {
                    result.append("za");
                } else {
                    result.append("az");
                }
                break;
            }

            if (dp[z][a - 1] >= K) { // a 넣기
                result.append("a");
                a = a - 1;
            } else if (dp[z][a - 1] < K) { // z 넣기
                result.append("z");
                K = K - dp[z][a - 1];
                z = z - 1;
            }
        }
        System.out.println(result);
    }
}
//    N=a의 개수, M=z의 개수라고 할 때, dp[N][M]은 조합의 총 개수이다.
/**
 * 점화식은 다음과 같다.
 * dp[N][M] = dp[N-1][M] + dp[N][M-1] 이다. 예를 들자면
 * dp[2][1]은 aaz, aza, zaa가 있다. 즉, 경우를 둘로 나눌 수 있다.
 * (1) a로 시작하는 경우 (2) z로 시작하는 경우
 * 만약 a로 시작한다면 a + (az or za) 이다. 즉 dp[1][1]의 개수이다.
 * z로 시작한다면 z + aa 이다. 즉 dp[2][0]의 값이다. 이런식으로 위 점화식을 통해 개수를 계산 가능하고,
 * dp[2][2]의 조합 중 a로 시작하는 개수는 dp[1][2]와 같다. a로 시작하면 반드시 그 뒤부터는 a가 하나 빠진 경우의 수만큼 오니까 말이다.
 *
 * 그리고 답도 이런식으로 구할 수 있는데 만약 N,M = 2이고, K = 5 라고 했을 때,
 * dp[2][2] = 6이다. 그리고 a로 시작하는 조합은 dp[1][2] 이기 떄문에 3까지이다. 하지만 K는 5이므로, 5번쨰 조합은 K로 시작하는 것이다.
 * 그러면 dp[2][1]로 이동한다. 여기서 또 a로 시작하는 조합인지 z로 시작하는지 정해야 한다. 그리고 K값은 dp[2][2]에서 a로 시작하는 경우의 수를 제외해야 하기 때문에 5 - 3 을 해서 2로 계산한다.
 * dp[2][1]에서 a로 시작하는 조합의 수는 dp[1][1]이다. 그렇다면 dp[1][1] = 2 이고, k도 2이기 떄문에 a로 시작한다. 그리고 dp[1][1]이 되었을 때, k가 1 이라면 az, k가 2라면 za 이다.
 * 또한 z = 0이 되면 aa를 해야하고, a = 0이 되면 zz를 반환 해야 한다.
 * 이때까지 조합의 경우를 보면 ka로 시작하는 것이다.
 * z -> a -> z -> a
 */