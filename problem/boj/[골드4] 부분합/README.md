## 부분합

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
|[백준](https://www.acmicpc.net/problem/1806)|부분합|골드 4|

### 문제 풀이

> 재풀이가 필요한 문제입니다. 

처음에 여러가지 풀이 방법을 생각했지만, N = 100,000이 까지 가능하여 시간 초과가 날 가능성이 많아서, 다른 타당한 방법을 생각해내지 못했다. 그렇게 힌트를 통해 `슬라이딩 윈도우 기법`을 통해 문제를 접근할 수 있다는 걸 알았다. 알고리즘은 간단하다. 현재 수열의 값이 S보다 작다면 오른쪽의 수를 계속해서 수열에 추가하고, 만약 S와 같거나 크다면 왼쪽부터 수열의 요소를 하나씩 제거하는 것이다.

```java
while(true) {
    if (value >= S) { // 축소
        result = Math.min((end - start) + 1, result);
        if (start == end) {
            if (end == numbers.length -1) {
                break;
            }
            start += 1;
            end += 1;
            value = numbers[end];
        } else {
            value -= numbers[start];
            start += 1;
        }
    } else { // 확장
        if (end == numbers.length - 1) {
            break;
        }
        end += 1;
        value += numbers[end];
    }
}
```

좀 난잡하게 표현한 것 같다. 다음과 같이 깔끔하게 정리할 수 있다.

```java
for (int right = 0; right < N; right++) {
    sum += arr[right];

    while (sum >= S) {
        minLen = Math.min(minLen, right - left + 1);
        sum -= arr[left++];
    }
}
```

이렇게 계속해서 수열의 길이 중 `최소값`을 계속해서 갱신하면서 반복문이 끝나면 해당 최소값을 출력하면 된다.