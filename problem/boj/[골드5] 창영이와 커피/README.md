## 창영이와 커피

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
|[백준](https://www.acmicpc.net/problem/22115)|창영이와 커피|골드 5|

### 문제 풀이

전형적인 `Knapsack Problem` 과 관련된 문제이다. 처음 데이터 하나를 DP에 저장하고, 중복을 허용하면 안되기 때문에, 뒤에서 배열을 조회하며 적정값을 찾으면 된다. 
다만 초기값을 설정 할 때, `K` 보다 큰 수가 주어질 수도 있다. 이런 경우 `IndexOutOfBounds` 에러가 발생할 수 있는데 이를 피하기 위해서 각 커피에 함유된 카페인 함유량이 `K` 보다 높으면 무시하면 된다.

```java
int count = 0;
for (int i=0; i<N; i++) {
    count = i;
    if (K >= C[i]) {
        dp[C[i]] = 1;
        break;
    }
}
```

그런 후, `Knapsack Problem` 풀이 방법을 통해 문제를 풀면 된다.

```java
for (int i=count+1; i<N; i++) {
    int target = C[i];
    for (int k=K; k>0; k--) {
        if (target == k && K >= target) {
            dp[k] = 1;
        }
        if (dp[k] != 100001) {
            if (k + target <= K) {
                dp[k+target] = Math.min(dp[k] + 1, dp[k+target]);
            }
        }
    }
}
```