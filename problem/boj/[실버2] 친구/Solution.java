import java.io.*;
import java.util.*;

public class BOJ_1058 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] people = new char[N][N];
        
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int k=0; k<N; k++) {
                people[i][k] = line.charAt(k);
            }
        }

        for (int i=0; i<N; i++) {
            Set<Integer> set = new HashSet<>();
            for (int k=0; k<N; k++) {
                if (people[i][k] == 'Y') {
                    set.add(k);
                    findFirends(i, k, people, set);
                }
            }
            answer = Math.max(set.size(), answer);
        }
        System.out.print(answer);
    }

    public static void findFirends(int prevNumber, int number, char[][] people, Set<Integer> set) {
        int N = people.length;
        for (int k=0; k<N; k++) {
            if (k != prevNumber && people[prevNumber][k] != 'Y' && people[number][k] == 'Y') { // 친구가 있으면
                set.add(k);
            }
        }
    }

}
