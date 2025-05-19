package org.example;

import java.io.*;
import java.util.*;

public class BOJ_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] value = new int[N+1][3];
        int[][] dp = new int[N+1][3];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            value[i][0] = Integer.parseInt(st.nextToken());
            value[i][1] = Integer.parseInt(st.nextToken());
            value[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = value[1][0];
        dp[1][1] = value[1][1];
        dp[1][2] = value[1][2];

        for (int i=2; i<=N; i++) {
            for (int k=0; k<3; k++) {
                if (k == 0) {
                    int first = dp[i-1][k+1] + value[i][k];
                    int second = dp[i-1][k+2] + value[i][k];
                    dp[i][k] = Math.min(first, second);
                } else if (k == 1) {
                    int first = dp[i-1][k-1] + value[i][k];
                    int second = dp[i-1][k+1] + value[i][k];
                    dp[i][k] = Math.min(first, second);
                } else { // k == 2
                    int first = dp[i-1][k-2] + value[i][k];
                    int second = dp[i-1][k-1] + value[i][k];
                    dp[i][k] = Math.min(first, second);
                }
            }
        }
        int minResult = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
        System.out.println(minResult);
    }
}