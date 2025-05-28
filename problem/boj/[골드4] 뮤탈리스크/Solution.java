import java.io.*;
import java.util.*;

public class BOJ_12869 {

    static int[][] damages = new int[][] {
        {9, 3, 1},
        {9, 1, 3},
        {3, 1, 9},
        {3, 9, 1},
        {1, 3, 9},
        {1, 9, 3},
    };

    static class Attack {
        int[] hp;
        int[] damage;
        int count;

        public Attack(int[] hp, int[] damage, int count) {
            this.hp = hp;
            this.damage = damage;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] scv = new int[3];
        boolean[][][] visited = new boolean[61][61][61];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
           scv[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Attack> queue = new LinkedList<>();

        for (int i=0; i< damages.length; i++) {
            queue.add(new Attack(scv.clone(), damages[i], 0));
        }

        int minAttackCount = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Attack at = queue.poll();

            int[] hp = at.hp;
            int[] damage = at.damage;
            int count = at.count;

            hp[0] = Math.max(hp[0] - damage[0], 0);
            hp[1] = Math.max(hp[1] - damage[1], 0);
            hp[2] = Math.max(hp[2] - damage[2], 0);

            if (hp[0] == 0 && hp[1] == 0 && hp[2] == 0) {
                minAttackCount = count + 1;
                break;
            } else if (!visited[hp[0]][hp[1]][hp[2]]) {
                visited[hp[0]][hp[1]][hp[2]] = true;
                for (int i=0; i< damages.length; i++) {
                    queue.add(new Attack(hp.clone(), damages[i], count + 1));
                }
            }
        }
        System.out.println(minAttackCount);
    }
}