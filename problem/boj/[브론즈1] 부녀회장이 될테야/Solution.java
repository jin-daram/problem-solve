package org.example;

import java.io.*;
import java.util.*;

public class BOJ_2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> results = new ArrayList<>();

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            int[][] dp = new int[K+1][N+1];
            for (int a=0; a<=N; a++) {
                dp[0][a] = a;
            }

            for (int b=1; b<=K; b++) {
                for (int c=1; c<=N; c++) {
                    if (c == 1) {
                        dp[b][c] = dp[b-1][c];
                    } else {
                        dp[b][c] = dp[b][c-1] + dp[b-1][c];
                    }
                }
            }

            results.add(dp[K][N]);
        }

        for (Integer result : results) {
            System.out.println(result);
        }

    }

}
