package org.example;

import java.io.*;
import java.util.*;

/**
 * 백준 7576번 토마토
 */

public class BOJ_7576 {

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로

        Queue<int[]> queue = new LinkedList<>();

        int[][] box = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                box[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (box[i][k] == 1) {
                    int[] tomato = new int[3];
                    tomato[0] = k; // x
                    tomato[1] = i; // y
                    tomato[2] = 0;
                    queue.add(tomato);
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();

            days = Math.max(tomato[2], days);

            for(int dir=0; dir<4; dir++) {
                int nx = tomato[0] + dx[dir];
                int ny = tomato[1] + dy[dir];

                if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                    if (box[ny][nx] == 0) {
                        box[ny][nx] = 1;
                        int[] newTomato = new int[3];
                        newTomato[0] = nx;
                        newTomato[1] = ny;
                        newTomato[2] = tomato[2] + 1;
                        queue.add(newTomato);
                    }
                }

            }
        }
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (box[i][k] == 0) days = -1;
            }
        }
        System.out.println(days);
    }
}