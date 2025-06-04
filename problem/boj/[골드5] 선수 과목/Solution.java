import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);

        Map<Integer, List<Integer>> map = new HashMap(); // List는 선수해야하는 과목임.
        for (int i=1; i<=N; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int preSubject = Integer.parseInt(st.nextToken());
            int subject = Integer.parseInt(st.nextToken());

            map.get(subject).add(preSubject);
        }

        for (int i=1; i<=N; i++) {
            if (map.get(i).size() != 0) { // 선수 있음
                int max = 0;
                for (int k=0; k<map.get(i).size(); k++) {
                    max = Math.max(dp[map.get(i).get(k)], max);
                }
                dp[i] = max + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[1]);
        for (int i=2; i<=N; i++) {
            sb.append(" " + dp[i]);
        }
        System.out.println(sb);
    }

}
