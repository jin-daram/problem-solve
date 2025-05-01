## 전력망을 둘로 나누기

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
| [프로그래머스](https://school.programmers.co.kr/learn/courses/30/lessons/86971)|전력망을 둘로 나누기|Lv.2|

DFS를 통해 풀었다. 문제의 핵심은 전력망이 둘로 나뉘었을 때, 각각의 이어진 모든 송전탑의 개수를 구하는 것이다. 예를 들어 송전탑이 총 4개가 있고 (n=4), 연결은 다음과 같이 되어있다.
```
[[1,2], [2,3], [3,4]]
```

이런식으로 연결되어있을 때, 어디를 잘라야 둘로 나뉜 전력망에 연결된 송전탑의 개수의 차이가 가장 적은지 물어보는 문제이다. 위와 같은 상황의 경우 `[2,3]`을 자르게 되면 각각 전력망에 연결된 송전탑의 개수가 2개, 2개로 나뉘게 되고, 서로의 전력망의 송전탑의 개수 차이는 0개로 가장 적은 수가 된다. 

전력망이 둘로 나뉘었을 떄, 각 나눠지는 기준이 된 송전탑을 기점으로 DFS를 통해 연결된 송전탑의 개수를 찾아내고 이 둘의 차이를 구하여 min 값에 동기화 시키면 된다. 그리고 이러한 것을 모든 wires의 요소에 적용시키면, 어느 전선을 잘라야 서로의 차이가 최소가 되는지 알 수 있다.

```java
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
```

나의 경우는 wires[] 자체를 넘기고, 자른 전선를 제외한 배열을 순회하면서 DFS를 돌렸다. 