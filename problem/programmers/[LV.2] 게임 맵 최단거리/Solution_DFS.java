class Solution {
    
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    private int result = 10000;
    
    public int solution(int[][] maps) {    
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;        
        dfs(maps, 0, 0, visited, 1);
        if (result == 10000) return -1;
        return result;
    }
    
    public void dfs(int[][] maps, int x, int y, boolean[][] visited, int count) {
        int n = maps[0].length;
        int m = maps.length;
        
        if (x == n-1 && y == m-1) {
            result = Math.min(result, count);
            return;
        }
        
        for (int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (maps[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dfs(maps, nx, ny, visited, count + 1);
                    visited[ny][nx] = false;
                }
            }
        }
    }
}