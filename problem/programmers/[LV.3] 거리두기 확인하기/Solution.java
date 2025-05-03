class Solution {
    
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    int[] answer = new int[5];
    boolean result = true;

    public int[] solution(String[][] places) {
        for (int i=0; i<places.length; i++) {
            char[][] room = getCharArr(places[i]);
            tourRoom(checkDistance, i);
        }

        return answer;
    }

    public void checkDistance(char[][] room, int index) {
        result = true;
        for (int y=0; y<5; y++) {
            for (int x=0; x<5; x++) {
                if (room[y][x] == 'P') {

                    dfs(room, x, y, 0, new boolean[5][5]);
                    if (!result) {
                        answer[index] = 0;
                        return;
                    }
                }
            }
        }
        answer[index] = 1;
    }

    public char[][] getCharArr(String[] room) {
        char[][] returnValues = new char[5][5];
        for (int i=0; i<room.length; i++) {
            char[] returnValue = new char[5];
            for (int k=0; k<room[i].length(); k++) {
                returnValue[k] = room[i].charAt(k);
            }
            returnValues[i] = returnValue;
        }

        return returnValues;
    }


    public void dfs(char[][] room, int x, int y, int index, boolean[][] visited) {
        visited[y][x] = true;
        for (int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (0 <= nx && nx < room[0].length && 0 <= ny && ny < room.length) {
                if (!visited[ny][nx]) {
                    if (room[ny][nx] == 'O' && index == 0) dfs(room, nx, ny, 1, visited);

                    if (room[ny][nx] == 'P') {
                        result = false;
                        return;
                    }
                }
            }
        }
    }
}