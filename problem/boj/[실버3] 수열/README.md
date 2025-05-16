## 수열

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
|[백준](https://www.acmicpc.net/problem/2559)|수열|실버 3|

### 문제 풀이
쉬운 문제이다. 전체 날짜 수 N에서 연속적인 날짜의 수 K를 `슬라이딩 윈도우` 알고리즘을 통해 연속된 범위가 가지는 최대값을 구하면 된다.

```java
for (int i=1; i<=K; i++) {
    result += numbers[i];
}

max = result;

for (int i=K+1; i<=N; i++) { // N = 10, K = 5
    int newResult = result + numbers[i] - numbers[i-K];
    max = Math.max(max, newResult);
    result = newResult;

}
System.out.println(max);
```
