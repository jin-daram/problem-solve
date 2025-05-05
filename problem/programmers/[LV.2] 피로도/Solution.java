class Solution {
    
    private int[][] D;
    private int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
        D = dungeons;
        dfs(k, 0, new boolean[D.length]);
        return maxCount;
    }
    
    public void dfs(int k, int count, boolean[] visited) {
        for (int i=0; i<D.length; i++) {
            if (!visited[i] && k >= D[i][0]) {
                visited[i] = true;
                dfs(k - D[i][1], count+1, visited);
                visited[i] = false;
            }
        }
        maxCount = Math.max(maxCount, count);
    }
}