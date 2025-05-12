package org.example;

import java.io.*;
import java.util.*;

public class BOJ_14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] sche = new int[N+1][2];
        int[] dp = new int[50];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            sche[i][0] = time;
            sche[i][1] = money;
        }

        for (int i=1; i<=N; i++) {
            int time = sche[i][0];
            int money = sche[i][1];

            if (time == 1) {
                dp[i] = Math.max(dp[i], dp[i-1] + money);
            } else {
                dp[i] = Math.max(dp[i], dp[i-1]);
                dp[i + (time-1)] = Math.max(dp[i+(time-1)], dp[i-1] + money);
            }
        }
        System.out.println(dp[N]);
        }
    }