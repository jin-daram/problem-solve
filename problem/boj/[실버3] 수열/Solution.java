import java.io.*;
import java.util.*;

public class BOJ_2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // K일까지의 합계 구하기
        int max;
        int result = 0;
        for (int i=1; i<=K; i++) {
            result += numbers[i];
        }

        max = result;

        for (int i=K+1; i<=N; i++) { // N = 10, K = 5
            int newResult = result + numbers[i] - numbers[i-K];
            max = Math.max(max, newResult);
            result = newResult;

        }
        System.out.println(max);
    }
}