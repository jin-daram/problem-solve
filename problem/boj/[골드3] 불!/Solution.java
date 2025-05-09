import java.io.*;
import java.util.*;

public class BOJ_4179 {

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static char[][] map;
    public static int R;
    public static int C;

    public static boolean[][] av;
    public static boolean[][] jihoonVisited;
    public static boolean[][] fireVisited;

    public static boolean find = false;

    public static int answer = -1;
    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        av = new boolean[R][C];
        jihoonVisited = new boolean[R][C];
        fireVisited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String line = br.readLine();
            for (int k = 0; k < C; k++) {
                map[i][k] = line.charAt(k);
            }
        }

        int[] jihoonStart = new int[4];

        for(int i=0; i<R; i++) {
            for (int k = 0; k < C; k++) {
                if (map[i][k] == 'J' || map[i][k] == '.') av[i][k] = true;
                if (map[i][k] == 'F') {
                    fireVisited[i][k] = true;
                    int[] a = new int[4];
                    a[0] = 1;
                    a[1] = k;
                    a[2] = i;
                    a[3] = 0;
                    queue.add(a);
                }
                if (map[i][k] == 'J') {
                    jihoonStart[0] = 0;
                    jihoonStart[1] = k;
                    jihoonStart[2] = i;
                    jihoonStart[3] = 0;
                    jihoonVisited[i][k] = true;
                }
            }
        }

        queue.add(jihoonStart);

        while(!queue.isEmpty() && !find) {
            int[] todo = queue.poll();
            move(
                todo[0],
                todo[1],
                todo[2],
                todo[3]
            );
        }

        if (answer == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }

    }

    public static void move(int type, int x, int y, int time) {
        if (type == 0 && isMapAround(x, y)) {
            find = true;
            answer = time + 1;
            return;
        }

        for (int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (0 <= nx && nx < C && 0 <= ny && ny < R) { // 이동할 수 있는 지형임.
                if (map[ny][nx] != '#') { // 벽이 아닌 경우
                    if (type == 1 && !fireVisited[ny][nx]) { // 불 번짐
                        fireVisited[ny][nx] = true;
                        av[ny][nx] = false;
                        int[] fire = new int[4];
                        fire[0] = 1;
                        fire[1] = nx;
                        fire[2] = ny;
                        fire[3] = time + 1;
                        queue.add(fire);
                    }

                    if (type == 0 && av[ny][nx] && !jihoonVisited[ny][nx]) {
                        jihoonVisited[ny][nx] = true;
                        // 큐에 지훈이 이동 넣기
                        int[] jihoon = new int[4];
                        jihoon[0] = 0;
                        jihoon[1] = nx;
                        jihoon[2] = ny;
                        jihoon[3] = time + 1;
                        queue.add(jihoon);
                    }
                }
            }
        }
    }

    public static boolean isMapAround(int x, int y) {
        return (x == 0 || x == C-1) || (y == 0 || y == R-1);
    }
}