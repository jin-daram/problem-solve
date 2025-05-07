import java.io.*;
import java.util.*;

public class BOJ_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int result = 0;
        int left = 0;
        int right = trees[N-1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long totalCut = getSliceTree(trees, mid); // ← long으로 수정

            if (totalCut >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
    public static long getSliceTree(int[] trees, int cutHeight) {
        long result = 0;
        for (int tree : trees) {
            if (tree > cutHeight) {
                result += (tree - cutHeight);
            }
        }
        return result;
    }

}
