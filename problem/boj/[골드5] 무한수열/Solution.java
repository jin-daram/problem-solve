import java.io.*;
import java.util.*;

public class BOJ_1351 {

    public static Map<Long, Long> memoMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long Q = Long.parseLong(st.nextToken());
        memoMap = new HashMap<>();

        System.out.println(recursive(N, P, Q));
    }

    public static long recursive(long n, long p, long q) {
        if (memoMap.get(n) != null) return memoMap.get(n);
        if (n == 0) return 1;
        memoMap.put(n, recursive(n/p, p ,q) + recursive(n/q, p, q));
        return memoMap.get(n);
    }

}
