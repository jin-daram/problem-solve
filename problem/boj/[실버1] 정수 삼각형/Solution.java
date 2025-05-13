package org.example;

import java.io.*;
import java.util.*;

public class BOJ_1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][N];


        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k=0; k<=i; k++) {
                int number = Integer.parseInt(st.nextToken());
                triangle[i][k] = number;
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];

        for (int i=0; i<N-1; i++) {
            for (int k=0; k<i+1; k++) {
                dp[i+1][k] = Math.max(dp[i+1][k], dp[i][k] + triangle[i+1][k]);
                dp[i+1][k+1] = Math.max(dp[i+1][k+1], dp[i][k] + triangle[i+1][k+1]);
            }
        }

        int[] resultArr = dp[N-1];
        Arrays.sort(resultArr);
        System.out.println(resultArr[resultArr.length-1]);
    }
}
