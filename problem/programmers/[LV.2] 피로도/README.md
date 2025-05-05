## 피로도
|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
| [프로그래머스](https://school.programmers.co.kr/learn/courses/30/lessons/87946)|피로도|Lv.2|

### 문제 풀이
DFS + 백트래킹을 통해 해결할 수 있는 문제이다. 하나의 던전을 여러 번 돌 수 없다. 그렇기 때문에 유효한 값이 나올 때까지 모든 경우의 수를 탐색해야 하기 떄문에 다음과 같이 백트래킹을 구현한다. 
```java
visited[i] = true;
dfs(k - D[i][1], count+1, visited);
visited[i] = false;
```