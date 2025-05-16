package org.example;

import java.io.*;
import java.util.*;

public class BOJ_2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K+1];
        int[] numbers = new int[N];

        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<N; i++) {
            int number = numbers[i];
            for (int k=number; k<=K; k++) {
                dp[k] = Math.min(dp[k], dp[k-number] + 1);
            }
        }
        if (dp[K] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}