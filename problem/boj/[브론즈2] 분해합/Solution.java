package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i=1; i<=N; i++) {
            if (getD(i) == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    public static int getD(int number) {
        int result = number;

        String nums = String.valueOf(number);
        for (int i=0; i<nums.length(); i++) {
            result += nums.charAt(i) - '0';
        }
        return result;
    }

}
