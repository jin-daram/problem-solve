# 동적 계획법 (Dynamic Programming)
큰 문제를 작은 문제로 나누고, 중복 계산을 줄이기 위해 결과를 저장해서 다시 쓰는 기법

## 구현 방식
- Top-down
- Bottom-up


### Top-Down
Top-down 방식은 재귀 + 메모이제이션 방법을 사용하여 구현한다.

> 메모이제이션(Memoization) 이란?
이미 계산한 값을 저장해두고, 나중에 또 필요하면 해당 값을 불러와서 쓰는 형태. 재귀로 함수를 호출하다 보면 같은 파라미터를 갖는 함수를 여러 번 호출해야할 때가 있다. 
이 때, 해당 함수를 호출하지 않고, 값을 미리 저장하여 불러와서 사용하면 연산을 줄일 수 있다.

```java

int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

이런 코드가 있을 때, 우리 `n == 4` 라면 `return fib(3) + fib(2);`가 된다. 근데 여기서 불필요한 계산이 하나 들어간다. fib(2) 라는 함수가 fib(3)에서 한번 더 사용되기 때문에 fib(2)는 2번 호출된다. 그렇게 되면 연산이 많아져 성능이 느려질 수 있다. 이를 최소화하기 위한 방법이 바로 메모이제이션이다. 

```java
# 메모이제이션 적용
int memo[] = new int[100];

int fib(int n) {
    if (n <= 1) return n;
    if (memo[n] != 0) return memo[n]; // 재사용
    return memo[n] = fib(n - 1) + fib(n - 2);
}
```

이런식으로 작성하게 되면 `n == 4` 일 경우 함수 호출 과정은 다음과 같다.

```
fib(4) ->
    fib(2) ->
        fib(0) -> return 0
        fib(0) <- 
        fib(1) -> return 1
        memo[2] = 0 + 1;
    fib(2) <-
    fib(3) ->
        fib(1) -> return 1
        fib(1) <-
        fib(2) -> Memoization 1
        fib(2) <-
        memo[3] = 1 + 1;
    fib(3) <-
fib(4) <- return 3
```

`fib(2)`를 호출 할 떄 `fib(0)`, `fib(1)`을 호출해야 하지만, `Memoization`을 통해 기록해두었기 때문에 연산할 필요가 없어진다. 

이렇게 Top-Down 방식은 큰 문제를 풀기 위해 필요한 작은 문제들을 재귀적으로 호출할 떄 사용한다. 하지만 입력 크기나 재귀가 깊어질 경우, `StackOverflow` 위험이 있다.

### Bottom-Up
Bottom-Up 방식은 가장 작은 문제부터 차례대로 풀고, 큰 문제의 정답을 점점 쌓아나가는 것이다. 이는 반복문으로 구현이 가능하기 때문에 StackOverflow에 대한 위험이 상대적으로 적다.

```java
void main() {
    int n = 4;
    int result = fib(n);
}

int fib(int n) {
    if (n<=1) return n;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i=2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
}
```

피보나치 수열 문제를 Bottom-up 방식으로 구현하게 되면 가장 작은 0과 1은 정해놓고, 2부터 앞의 두 수를 더해가며 값을 채워나간다. 이를 i가 N이 될 떄 까지 반복하고, 값을 return 한다. 모든 경우를 계산해야 하기 때문에 메모리와 시간 낭비가 가능하지만 대부분의 코딩 테스트에서는 안전한 방법이다. 하지만 문제 구조가 트리 구조이거나, 메모리 제한이 상대적으로 자유롭다면 Top-Down 방식을 선택하는 것도 좋은 방법이다.