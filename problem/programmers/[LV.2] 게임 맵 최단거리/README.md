## 게임 맵 최단거리

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
| [프로그래머스](https://school.programmers.co.kr/learn/courses/30/lessons/1844)|게임 맵 최단거리|Lv.2|


### 풀이
처음에는 단순히 `DFS`로 접근해서 풀었다. 하지만 최단 거리를 구하는 문제이기 때문에 결과값 검증에는 문제가 없었으나, `효율성 검사`에서 채점에 실패했다. 

[DFS 코드](./Solution_DFS.java)

BFS로 풀어야 하는 것은 알고 있었지만, BFS 구현법에 대해서는 아직 잘 몰라서, 우선은 DFS로 풀어봤다. 전체적인 접근은 다음과 같다.

DFS/BFS를 통해 (0,0)에서 각 타일을 차례대로 방문한다. 이 떄 DFS로 방문하게 되면 목적지까지 도달하는 모든 경우의 수를 계산하여 `Math.min()` 을 통해 최소값을 구하여 return 한다. 하지만 최단 거리를 구하는 문제는 BFS를 통해 많이 풀기 때문에 위 접근은 시간 초과가 날 가능성이 높다. 

**BFS**
[BFS 코드](./Solution_BFS.java)

BFS는 넓이 우선 탐색으로써 DFS를 처럼 하나를 깊게 파는 게 아니라 넓게 넓게 파고든다. 

```
        1
      / | \
    2   3   4
   /    |    \ 
  5     6     7
```

이러한 트리가 있을 때, `DFS`는 다음과 같이 조회하게 된다.
```
1 -> 2 -> 5 -> 3 -> 6 -> 4 -> 7
```

분기가 있어도 그 중 하나를 가장 깊게 탐색하고, 그 탐색이 끝나야 다음 탐색으로 넘어간다.

하지만 `BFS`의 접근은 다음과 같다.

```
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
```

이러한 접근은 Queue를 통해 쉽게 구현할 수 있다. 1번 노드에서 시작할 때, Queue에 다음으로 이동해야 할 번호를 추가한다.
```
Queue: => [][][][][][4][3][2] =>
```

그리고 가장 Queue 상위에 있는 값을 가져오고, 그 값에서 이동할 수 있는 번호를 또 Queue에 추가한다.

```
Queue: => [][][][][][5][4][3] =>
```

이런식으로 계속 반복하게 되면 아까 제시한 BFS의 탐색 순서와 같이 접근할 수 있다. 코드로 보면 다음과 같다.

```java
public bfs() {
    Queue<Integer> queue = new LinkedList();

    queue.offer(1);

    while(!queue.isEmpty()) {
        Integer currentValue = queue.poll();

        if (...) {
            return ...
        }

        for (...) {
            // 다음으로 이동할 번호 탐색
            queue.offer(number);
        }
    }
}
```

이러한 접근으로 `게임 맵 최단거리`를 접근하면 간단하게 풀 수 있다.