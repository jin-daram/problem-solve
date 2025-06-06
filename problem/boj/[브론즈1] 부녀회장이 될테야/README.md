## 부녀회장이 될테야

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
|[백준](https://www.acmicpc.net/problem/2775)|부녀회장이 될테야|브론즈1|

### 문제 풀이
DP 중에서도 간단한 문제이다. 문제를 요약해보면 K층 N호에 살 수 있는 사람은 K-1층의 1호부터 N호까지 살고 있는 사람의 수를 합한 값이다.


||1호|2호|3호|
|-|-|-|-|
|3층|1|4|10|
|2층|1|3|6|
|1층|1|2|3|

애초에 DP 식을 문제에서 알려주고 있어서, 1호일 때만 조건을 잘 나누어서 코드를 짜면 쉽게 풀 수 있다. 점화식은 다음과 같다.

```
dp[K][N] = dp[K][N-1] + dp[K-1][N];
```

위 표를 기준으로 `2층 2호`의 값은 `1층 1호+2호`의 값이다. 즉 2층 3호 값을 구하려고 할 때, 일일이 1층 1호~3호까지의 값을 더하는게 아니라, DP를 이용해 2층 2호의 값을 이용하여 2층 3호의 값을 더하는 것이다. `K-1층의 N호`의 값을 `K층의 N-1호`의 값과 더해주면 `K층의 N호` 값을 구할 수 있다.



