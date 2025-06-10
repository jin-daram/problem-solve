## RGB 거리 2

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
|[백준](https://www.acmicpc.net/problem/17404)|RGB 거리 2|골드 4|

### 문제 풀이

3차원 DP 배열을 통해 풀 수 있는 문제이다. `Z축` 에는 첫 번째에 칠한 색의 경우이다. 예를 들어 `dp[1][1][0]` 는 [1][1] 까지 왔을 때, 1번째에 `RED` 색으로 칠한 최소값이다. 이런식으로 각각 위치의 `RED`, `GREEN`, `BLUE` 를 첫 번째 집으로 칠했을 때의 최소값을 구한다.

- 마지막 집을 `RED` 로 칠했을 때는 [1], [2] 중 최소값 
- 마지막 집을 `GREEN` 으로 칠했을 때, [0], [2] 중 최소값
- 마지막 집을 `BLUE` 로 칠했을 때, [0], [1] 중 최소값

이 3가지 경우의 중 가장 작은 값을 출력하면 된다. 코드는 다음과 같다.

```java
for (int i=2; i<N; i++) {
    for (int k=0; k<3; k++) {
        if (k == 0) {
            dp[i][k][0] = Math.min(dp[i-1][k+1][0] + map[i][k], dp[i-1][k+2][0] + map[i][k]);
            dp[i][k][1] = Math.min(dp[i-1][k+1][1] + map[i][k], dp[i-1][k+2][1] + map[i][k]);
            dp[i][k][2] = Math.min(dp[i-1][k+1][2] + map[i][k], dp[i-1][k+2][2] + map[i][k]);
        } else if (k == 1) {
            dp[i][k][0] = Math.min(dp[i-1][k-1][0] + map[i][k], dp[i-1][k+1][0] + map[i][k]);
            dp[i][k][1] = Math.min(dp[i-1][k-1][1] + map[i][k], dp[i-1][k+1][1] + map[i][k]);
            dp[i][k][2] = Math.min(dp[i-1][k-1][2] + map[i][k], dp[i-1][k+1][2] + map[i][k]);
        } else { // k == 2
            dp[i][k][0] = Math.min(dp[i-1][k-2][0] + map[i][k], dp[i-1][k-1][0] + map[i][k]);
            dp[i][k][1] = Math.min(dp[i-1][k-2][1] + map[i][k], dp[i-1][k-1][1] + map[i][k]);
            dp[i][k][2] = Math.min(dp[i-1][k-2][2] + map[i][k], dp[i-1][k-1][2] + map[i][k]);
        }
    }
}
```

다소 코드가 복잡해보이지만, 단순하다. 각 위치에 대한 최소값을 3개 구하면 된다. 
- 첫번째 집을 `RED` 로 칠했을 때의 최소값 
이전 집에 칠한 색은 현재 집에 칠하지 못하므로, `dp[i-1][k+1]`,` dp[i-1][k+2]` 의 경우 중 첫번째 집을 빨간색으로 칠한 집의 최소값을 저장하면 된다.
```
// k == 0
dp[i][k][0] = Math.min(dp[i-1][k+1][0] + map[i][k], dp[i-1][k+2][0] + map[i][k]); 

// k == 1
dp[i][k][0] = Math.min(dp[i-1][k-1][0] + map[i][k], dp[i-1][k+1][0] + map[i][k]); 

// k == 2
dp[i][k][0] = Math.min(dp[i-1][k-2][0] + map[i][k], dp[i-1][k-1][0] + map[i][k]); 
```

- 첫번째 집을 `GREEN` 으로 칠했을 때의 최소값
```
// k == 0
dp[i][k][1] = Math.min(dp[i-1][k+1][1] + map[i][k], dp[i-1][k+2][1] + map[i][k]); 

// k == 1
dp[i][k][1] = Math.min(dp[i-1][k-1][1] + map[i][k], dp[i-1][k+1][1] + map[i][k]); 

// k == 2
dp[i][k][1] = Math.min(dp[i-1][k-2][1] + map[i][k], dp[i-1][k-1][1] + map[i][k]); 
```

- 첫 번쨰 집을 `BLUE` 로 칠했을 때의 최소값
```
// k == 0
dp[i][k][2] = Math.min(dp[i-1][k+1][2] + map[i][k], dp[i-1][k+2][2] + map[i][k]); 

// k == 1
dp[i][k][2] = Math.min(dp[i-1][k-1][2] + map[i][k], dp[i-1][k+1][2] + map[i][k]); 

// k == 2
dp[i][k][2] = Math.min(dp[i-1][k-2][2] + map[i][k], dp[i-1][k-1][2] + map[i][k]); 
```

이를 이용해서 최소값을 구하면 된다.