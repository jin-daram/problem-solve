import java.util.Arrays;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[n+1][m+1];
            boolean[][] puddlesMap = new boolean[n+1][m+1];

            for (int[] puddle : puddles) {
                int puddleX = puddle[0];
                int puddleY = puddle[1];
                puddlesMap[puddleY][puddleX] = true;
            }

            for (int i=1; i<=m; i++) {
                if (!puddlesMap[1][i]) dp[1][i] = 1; 
                if (puddlesMap[1][i]) break;
            }

            for (int i=1; i<=n; i++) {
                if (!puddlesMap[i][1]) dp[i][1] = 1;
                if (puddlesMap[i][1]) break;
            }

            for (int y=2; y<=n; y++) {
                for (int x=2; x<=m; x++) {
                    if (!puddlesMap[y][x]) { // 장애물이 존재하면 해당 경로는 0
                        dp[y][x] = (dp[y-1][x] + dp[y][x-1]) % 1000000007;
                    }
                }
            }
            return dp[n][m];
        }
}