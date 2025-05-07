import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        for (int i=0; i<M; i++) {
            boolean find = false;
            int left = 0;
            int right = N - 1;
            int target = targets[i];
            
            while (left <= right) {
                int mid = (left + right) / 2;

                if (numbers[mid] == target) {
                    System.out.println("1");
                    find = true;
                    break;
                }
                else if (numbers[mid] < target) left = mid + 1;
                else right = mid - 1;
            }

            if (!find) System.out.println("0");
        }
    }
}
