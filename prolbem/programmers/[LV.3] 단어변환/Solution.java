package org.example;

public class Solution_43163 {

    private int result = 60;
    private boolean success = false;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        DFS(words, begin, target, 0, visited);
        if (!success) return 0;
        return result;
    }

    public boolean isDiffOneChar(String begin, String target) {
        int diffCount = 0;
        for (int i=0; i<begin.length(); i++)
            if (begin.charAt(i) != (target.charAt(i))) diffCount++;

        return diffCount == 1;
    }

    public void DFS(String[] words, String begin, String target, int count, boolean[] visited) {
        if (target.equals(begin)) {
            success = true;
            if (result > count) result = count;
            return;
        }

        for (int i=0; i<words.length; i++) {
            if (isDiffOneChar(begin, words[i]) && !visited[i]) {
                visited[i] = true;
                DFS(words, words[i], target, count + 1, visited);
                visited[i] = false;
            }
        }
    }

}
