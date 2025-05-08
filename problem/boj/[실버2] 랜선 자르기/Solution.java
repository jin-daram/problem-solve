import java.io.*;
import java.util.*;

public class BOJ_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // K: 가지고 있는 랜선 수 / N: 필요한 랜선 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] lines = new long[K];

        for (int i=0; i<K; i++) lines[i] = Integer.parseInt(br.readLine());
        Arrays.sort(lines);

        long max = 0;
        long left = 1, right = lines[lines.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long cutLines = 0;
            for (long line : lines) {
                cutLines += line / mid;
            }
            if (cutLines >= N) {
                max = Math.max(mid, max);
                left = mid + 1;
            } else right = mid - 1;
        }
        System.out.println(max);
    }
}