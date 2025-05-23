## 동물원

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
|[백준](https://www.acmicpc.net/problem/1309)|동물원|실버 1|

### 문제 풀이

나한테는 좀 어려워서, 해설을 봐야 풀 수 있었다. 먼저 점화식을 구하는 과정이 좀 어려웠다. 이것을 이해한 내용을 적어보고자 한다.
세로로 긴 2xN 사자 우리에 새로운 2x1 사자 우리를 추가하게 되면 다음과 같은 경우의 수가 생긴다.

(1) 새로운 우리에 사자를 넣지 않는다.
(2) 새로운 우리에 사자를 넣는다.

**(1) 새로운 우리에 사자를 넣지 않는다.**
`N = 3` 이라고 가정했을 때, 새로운 우리에 사자를 넣지 않는 경우의 수는 `N == 2` 일 때의 경우의 수와 같다. 

**(2) 새로운 우리에 사자를 넣는다.**
새로운 우리에 사자를 넣을 때는 조건을 만족해야 한다. 그 조건은 사자들은 서로 가로나 세로에 연속되어 배치될 수 없다. 반드시 인접한 우리와는 떨어져 있어야 한다. 하지만 새로운 우리에 무턱대로 사자를 넣게 되면 문제가 생길 수 있다. 그렇기 때문에 조건을 만족하는 경우를 봐야한다.

새로운 우리 왼쪽에 사자를 넣게 되면 이전 우리의 사자는 반드시 오른쪽에 사자가 배치 되어야 한다. 혹은 이전 우리 양쪽에 모두 사자가 배치되지 않을 수도 있다.
새로운 우리 오른쪽에 사자를 넣게 되면 이전 우리의 사자는 반드시 왼쪽에 사자가 배치 돼야 한다. 혹은 이전 우리 양쪽에 모두 사자가 배치되지 않을 수도 있다.

가볍게 정리하면 다음과 같다.

```
추가된 우리에 사자를 넣는 경우의 수:
    추가된 우리 왼쪽에 사자 배치
        이전 우리에 사자 배치 안함: 조건 만족
        [❌][❌]
        [🦁][❌]

        이전 우리 오른쪽에 사자 배치: 조건 만족
        [❌][🦁]
        [🦁][❌]

    추가된 우리 오른쪽에 사자 배치:
        이전 우리에 사자 배치 안함: 조건 만족
        [❌][❌]
        [❌][🦁]

        이전 우리 왼쪽에 사자 배치: 조건 만족
        [🦁][❌]
        [❌][🦁]     
```

먼저 `이전 우리(N-1)`에 사자를 배치하지 않는 경우의 수는 어떨까? `N-1`까지 사자의 배치가 고정되어 있기 때문에 이는 `N-2`의 경우의 수와 같다. 점화식으로 계산하면 `dp[N-2]` 이다.
다음은 사자가 이전 우리에 배치 되어 있는 각각의 상태이다. `N = 3` 일 때, `N == 2` 에 사자가 배치되어 있으려면 N = 2, 일 때 N 번쨰 우리에 사자가 비어있으면 안된다. `dp[2]`는 7가지의 경우의 수가 가능한데, 여기서 N번쨰 우리에 사자가 배치되지 않는 수는 3개이다. 

그리고 이 경우는 `N == 1` 일때의 경우이다.

실제로 그림을 그려보면 `N = 2` 일 때, `N 번째 우리`에 사자가 배치되어 있지 않은 경우는, `N-1 번째` 우리가 `dp[1]`가 존재하는 만큼 있다. 즉 점화식으로 계산하면 다음과 같다.

```
dp[N-1] - dp[N-2]
```

이제 모든 점화식을 구했다. 각각의 값을 모두 더해주면 된다.

```
/* 전체 점화식 */
dp[N] = dp[N-1] + 2 * dp[N-2] + dp[N-1] - dp[N-2]
= 2 * dp[N-1] + dp[N-2]
```

전체 점화식은 위와 같다.

---
처음에 이러한 경우의 수를 생각하기 것이 어려웠던 것 같다. 전혀 다른 방법으로 접근하고 있었다. 앞으로 비슷한 문제를 만났을 때, 점화식을 세우는 과정을 좀 더 생각해보고, 앞으로 많은 문제를 풀어보면서 점화식을 세워나가는 연습을 해야겠다.