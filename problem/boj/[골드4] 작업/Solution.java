import java.io.*;
import java.util.*;

public class BOJ_2056 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[N+1];
        int[] inDegree = new int[N+1];

        // 선행조건 배열에서 1이면 1의 선행조건들을 담는게 아니라, 1이 선행조건이 되는 아이들을 넣는다. 예를 들어 1에 2, 4가 들어간다.
        List<List<Integer>> preCondition = new ArrayList<>(); // 선행 조건 배열
        for (int i=0; i<N+1; i++) {
            preCondition.add(new ArrayList<>());
        }
        int[] time = new int[N + 1]; // 각 작업 번호의 작업 시간 배열

        for (int i=1; i<N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            time[i] = t;
            for (int k=0; k<count; k++) {
                preCondition.get(Integer.parseInt(st.nextToken())).add(i);
                inDegree[i]++;
            }
        }

        for (int i=1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                dp[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            for (int target : preCondition.get(num)) {
                dp[target] = Math.max(time[target] + dp[num], dp[target]);
                inDegree[target]--;
                if (inDegree[target] == 0) queue.add(target);
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[N]);
    }
}