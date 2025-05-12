package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_2667_DFS {

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int N;

    public static int[][] map;
    public static boolean[][] visited;
    public static List<Integer> results = new ArrayList<>();

    public static int temp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int k=0; k<N; k++) {
                map[i][k] = line.charAt(k) - '0';
            }
        }

        for (int i=0; i<N; i++) {
            for (int k=0; k<N; k++) {
                if (map[i][k] == 1 && !visited[i][k]) {
                    visited[i][k] = true;
                    temp += 1;
                    dfs(k, i);
                    results.add(temp);
                    temp = 0;
                }
            }
        }
        System.out.println(results.size());
        Collections.sort(results);

        for(Integer result : results) {
            System.out.println(result);
        }
    }

    public static void dfs(int x, int y) {
        for (int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    temp += 1;
                    dfs(nx, ny);
                }
            }
        }
    }
}
