package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_67259_2 {

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    public class Road {
        public int x;
        public int y;
        public int direction;
        public int cost;

        public Road(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }

    public int solution(int[][] board) {
        int mx = board[0].length;
        int my = board.length;

        int[][][] visited = new int[board[0].length][board.length][4];
        Queue<Road> queue = new LinkedList<>();

        for (int x=0; x<board[0].length; x++) {
            for (int y=0; y<board.length; y++) {
                for (int dir=0; dir<4; dir++) {
                    visited[x][y][dir] = Integer.MAX_VALUE;
                }
            }
        }

        queue.offer(new Road(0, 0, -1, 0));

        while (!queue.isEmpty()) {
            Road currentRoad = queue.poll();
            for (int dir=0; dir<4; dir++) {
                int nx = currentRoad.x + dx[dir];
                int ny = currentRoad.y + dy[dir];

                if (0 <= nx && nx < mx && 0 <= ny && ny < my) {
                    if (board[ny][nx] == 0) { // 이동할 수 있으면
                        // 이동할 위치의 비용을 계산한다.
                        int newCost = currentRoad.cost + (currentRoad.direction == -1 || currentRoad.direction == dir ? 100 : 600); 
                        if (visited[nx][ny][dir] > newCost) {
                            visited[nx][ny][dir] = newCost;
                            queue.offer(new Road(nx, ny, dir, newCost));
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            // 도착지의 비용 중 가장 작은 값을 찾아 반환한다.
            min = Math.min(min, visited[mx-1][my-1][d]);
        }
        return min;
    }


}
