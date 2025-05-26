import java.io.*;
import java.util.*;

public class BOJ_1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int result = 100001;
        int value = numbers[0];
        int start = 0;
        int end = 0;
        while(true) {
            if (value >= S) { // 오른쪽으로 줄이기
                result = Math.min((end - start) + 1, result);
                if (start == end) {
                    if (end == numbers.length -1) {
                        break;
                    }
                    start += 1;
                    end += 1;
                    value = numbers[end];
                } else {
                    value -= numbers[start];
                    start += 1;
                }
            } else {
                if (end == numbers.length - 1) {
                    break;
                }
                end += 1;
                value += numbers[end];
            }
        }
        if (result == 100001) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}

/*
for (int right = 0; right < N; right++) {
    sum += arr[right];

    while (sum >= S) {
        minLen = Math.min(minLen, right - left + 1);
        sum -= arr[left++];
    }
}
*/