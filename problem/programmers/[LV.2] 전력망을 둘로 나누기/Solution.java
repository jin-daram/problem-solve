public class Solution {
    int currentCount = 1;
    public int solution(int n, int[][] wires) {

        int result = Integer.MAX_VALUE;

        for (int i=0; i<wires.length; i++) {
            int[] cut = wires[i];

            boolean[] visited = new boolean[101];
            visited[cut[0]] = true;
            dfs(wires, i, cut[0],  visited);
            int result1 = currentCount;
            currentCount = 1;

            visited = new boolean[101];
            visited[cut[1]] = true;
            dfs(wires, i, cut[1], visited);
            int result2 = currentCount;
            currentCount = 1;

            result = Math.min(Math.abs(result1 - result2), result);
        }

        return result;
    }

    public void dfs(int[][] wires, int cutWireIndex, int topNumber, boolean[] visited) {

        for (int i=0; i<wires.length; i++) {
            if (i != cutWireIndex) { // 잘린 전선은 패스
                if (wires[i][0] == topNumber && !visited[wires[i][1]]) {
                    visited[wires[i][1]] = true;
                    currentCount += 1;
                    dfs(wires, cutWireIndex, wires[i][1], visited);
                }

                if (wires[i][1] == topNumber && !visited[wires[i][0]]) {
                    visited[wires[i][0]] = true;
                    currentCount += 1;
                    dfs(wires, cutWireIndex, wires[i][0], visited);
                }
            }
        }
    }
}
