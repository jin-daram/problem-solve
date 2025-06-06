## 토마토

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
|[백준](https://www.acmicpc.net/problem/7576)|토마토|골드 5|

### 문제 풀이
처음에 풀었던 방식은 다음과 같다.

```
1. 비어있는 칸의 개수를 구한다. (N * M)
2. 현재 box의 익은 토마토 개수를 구한다. (N * M)
    2-1. 만약 현재 box의 익은 토마토 개수가 비어있는 칸의 개수를 제외한 칸의 개수와 같다면 return 한다.
3. 현재 box를 돌며 익은 토마토의 상하좌우 토마토를 익은 토마토로 바꾼다. (N * M)
4. (2)~(3) 과정을 재귀 호출 한다.
```

이 과정에서 `N * M` 번의 연산을 너무 많이 하니, N과 M이 극단적으로 주어졌을 때, 시간 초과가 나게 된다.

갈피를 못 찾다가 힌트를 얻어, BFS 방식으로 접근해야 시간 초과가 나지 않는다는 것을 알았다. 

BFS 방식은 맨 처음에만 N * M 연산을 통해 익은 토마토의 정보를 Queue에 넣는다. 그리고 Queue에서 익은 토마토의 정보를 하나씩 꺼내어, 상하좌우의 토마토를 조회하고 다시 Queue에 넣는다. 그리고 돌면서 익지 않은 토마토를 익은 토마토로 변경한다.

그리고 마지막에 상자를 전체 순회하면서 안 익은 토마토가 있는 지 확인한다. 없으면 최근에 갱신된 시간 데이터를 출력한다.

나는 마지막에 안 익은 토마토를 색출하려고 N * M 이라는 연산을 더 했지만, 초기 익은 토마토를 찾을 때, 총 토마토의 개수를 찾고, BFS를 돌면서 그 수를 하나씩 감소 시키고, 마지막에 그 수가 0이 아니라면 `-1`를 호출하도록 하는 편이 더 효율적이다.