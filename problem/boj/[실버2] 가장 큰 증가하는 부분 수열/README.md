## 가장 큰 증가하는 부분 수열

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
|[백준](https://www.acmicpc.net/problem/11055)|가장 큰 증가하는 부분 수열|실버 2|

### 문제 풀이
[가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053) 과 비슷한 문제이다. 이는 `dp[i]` 값에 `i번째`에 수까지 왔을 때, 가장 큰 값을 집어넣으면 된다. 

```
1 100 2 50 60 3 5 6 7 8
```

이라는 수열이 있을 때, `dp[2]`는 `101`이다. `dp[3]`은 `3`이다. 이처럼 `i번째`에 해당하는 `dp[i]`는 i번째에 만들 수 있는 가장 큰 부분 수열의 합이다. 점화식은 다음과 같다.

```java
for (int i=0; i<N; i++) {
    int targetNumber = numbers[i];
    for (int k=0; k<i; k++) {
        if (targetNumber > numbers[k]) dp[i] = Math.max(dp[i] , targetNumber + dp[k]);
        else dp[i] = Math.max(dp[i], targetNumber);
    }
}
```

마지막에 배열을 돌면서 가장 큰 값을 찾으면 정답을 구할 수 있다.