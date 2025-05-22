import java.io.*;
import java.util.*;

public class BOJ_1002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] inputs = new int[T][6];
        List<Integer> results = new ArrayList<>();


        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k=0; k<6; k++) {
                inputs[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<T; i++) {
            int x1 = inputs[i][0];
            int y1 = inputs[i][1];
            int r1 = inputs[i][2];
            int x2 = inputs[i][3];
            int y2 = inputs[i][4];
            int r2 = inputs[i][5];

            double distance = Math.abs(Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2 - y1), 2)));

            if (x1 == x2 && y1 == y2 && r1 == r2) results.add(-1);
            else if (r1 + r2 == distance || Math.abs(r2 - r1) == distance) results.add(1);
            else if (r1 + r2 < distance || Math.abs(r2 - r1) > distance) results.add(0);
            else results.add(2);
        }
        
        for(Integer result : results) {
            System.out.println(result);
        }
    }
}