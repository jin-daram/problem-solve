package org.example;

public class Solution43162OfProgrammers {

    private boolean[] check;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];

        for (int i=0; i<n; i++) {
            if (!check[i]) {
                answer++;
                find(computers, i);
            }
        }
        return answer;
    }

    // i번째에 연결된 컴퓨터를 확인하고 싶으면 computers[i][k] (i!=i) 를 확인하면 된다. 그리고 연결된 컴퓨터의 모든 그걸 찾아봐야한다.
    public void find(int[][] computers, int target) {
        check[target] = true;
        for (int i=0; i<computers[target].length; i++) {
            if (i == target) {
                continue;
            }

            if (computers[target][i] == 1 && !check[i]) {
                find(computers, i);
            }
        }
    }
    
}
