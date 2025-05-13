package org.example;

import java.io.*;
import java.util.*;

public class BOJ_12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물건 개수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[][] things = new int[N][2];
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            things[i][0] = Integer.parseInt(st.nextToken());
            things[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(things, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < N; i++) {
            for (int a=K; a>0; a--) {
                int W = things[i][0];
                int V = things[i][1];

                if (dp[a] != 0 && a + W <= K) {
                    dp[a + W] = Math.max(dp[a] + V, dp[a+W]);
                }

                if (a == W) {
                    dp[a] = Math.max(dp[a], V);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);
    }
}