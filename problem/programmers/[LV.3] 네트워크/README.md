## 네트워크

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
| [프로그래머스](https://school.programmers.co.kr/learn/courses/30/lessons/43162)|네트워크|Lv.3|

2차원 배열을 특이하게 사용했던 문제. 그러나 의외로 간단하게 풀 수 있었음.

### 풀이
먼저 문제에 대해 이해하고 들어가는게 중요하다. 처음에는 단순히 1 끼리 상하좌우로 묶여 있으면 하나의 네트워크인줄 알았지만, 문제를 자세히 읽어보니 그런 것이 아니었다. 

`컴퓨터 수: 5대`
```
  0 1 2 3 4
0 1 0 0 0 0  
1 0 1 0 0 0 
2 0 0 1 0 0
3 0 0 0 1 0
4 0 0 0 0 1
```

기본적으로 `computers[i][j]`는 1의 값을 가진다. 그렇기 때문에 위 배열이 기본적인 구조이다. 여기서 0번째 컴퓨터와 3번째 컴퓨터가 연결이 되어있다 라고하면 배열은 다음과 같이 바뀐다.

```
  0 1 2 3 4
0 1 0 0 1 0  
1 0 1 0 0 0 
2 0 0 1 0 0
3 1 0 0 1 0
4 0 0 0 0 1
```

그러면 `0-3`, `1`, `2`, `4` 이런식으로 4개의 네트워크가 구성된다. 이 점을 참고하여 DFS를 통해 문제를 풀면 된다.

먼저 컴퓨터의 수 만큼 for문을 반복한다. 여기서 각각의 n번째의 컴퓨터에 대해 네트워크가 연결되어있는지 확인한다.

```java
for (int i=0; i<n; i++) {
    if (...) {
        answer++;
        find(computers, i)
    }
}
```
여기서 하나의 컴퓨터가 다른 어느 컴퓨터와 네트워크에 연결되어있지 않더라도 네트워크로 분류되기 때문에 `answer++`를 해준다.

`find`라는 DFS 코드는 다음과 같다.

```java
public void find(int[][] computers, int target) {
    check[target] = true;
    for (int i=0; i<computers[target].length; i++) {
        if (i == target) {
            continue;
        }

        if (computers[target][i] == 1 && !check[i]) {
            find(computers, i);
        }
    }
}
```

쉽게 요약하자면, target `n` 이 주어지고, n번째와 연결된 모든 컴퓨터에 `check` 사인을 표시하는 것이다. 그럼 이후 for문에서 해당 컴퓨터의 네트워크 연결 여부는 계산하지 않아도 된다.