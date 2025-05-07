import java.io.*;
import java.util.*;

public class BOJ_10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        // 3. 체크할 숫자 개수
        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
        // 이분 탐색을 위한 정렬
        Arrays.sort(cards);

        StringBuffer sb = new StringBuffer("");

        for (int i=0; i<targets.length; i++) {
            boolean find = false;
            int left = 0, right = cards.length - 1, target = targets[i];
            while (left <= right) {
                int mid = (left + right) / 2;
                if (cards[mid] == target) {
                    find = true;
                    sb.append(" 1");
                    break;
                } else if (cards[mid] < target) { // 오른쪽 구간 탐색
                    left = mid + 1;
                } else {
                    right = mid - 1; // 왼쪽 구간 탐색
                }
            }
            if (!find) sb.append(" 0");
        }

        System.out.println(new StringBuffer(sb.toString().trim()));
    }

}