package org.example;

import java.io.*;
import java.util.*;

public class BOJ_2667_BFS {

    static class Home {
        public int x;
        public int y;

        public Home(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int N;

    public static int[][] map;
    public static Queue<Home> queue = new LinkedList<>();
    public static boolean[][] visited;

    public static List<Integer> results = new ArrayList<>();

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
                    Home home = new Home(k, i);
                    queue.add(home);
                    visited[i][k] = true;
                    results.add(bfs());
                }
            }
        }

        System.out.println(results.size());
        Collections.sort(results);
        for (Integer result : results) {
            System.out.println(result);
        }

    }

    public static int bfs() {
        int homeCount = 0;
        while(!queue.isEmpty()) {
            Home home = queue.poll();
            homeCount += 1;

            int x = home.x;
            int y = home.y;

            for(int dir=0; dir<4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (map[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        Home newHome = new Home(nx, ny);
                        queue.add(newHome);

                    }
                }

            }
        }
        return homeCount;
    }

}