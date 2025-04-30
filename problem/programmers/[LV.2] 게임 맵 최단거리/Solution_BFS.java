package org.example;

import java.util.*;

public class Solution_1844 {

    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};

    static class Node {
        public int x;
        public int y;
        public int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Node> queue = new LinkedList<>();

        int n = maps[0].length;
        int m = maps.length;

        queue.offer(new Node(0,0,1)); // 시작점 큐에 넣기
        visited[0][0] = true; // 시작점 방문 처리

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == n-1 && current.y == m-1) return current.count;

            for (int dir=0; dir<4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (maps[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new Node(nx, ny, current.count + 1));
                    }
                }
            }
        }
        return -1;
    }
}
