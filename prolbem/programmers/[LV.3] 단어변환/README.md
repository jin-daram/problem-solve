## 단어변환

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
| [프로그래머스](https://school.programmers.co.kr/learn/courses/30/lessons/43163)|단어변환|Lv.3|

DFS로 푼 문제다. 하지만 최소값을 구하는 문제이기 때문에 BFS를 이용하면 더 빨리 계산할 수 있다.

### 풀이
가장 중요한 건 `begin`과 비교하여 한 글자만 다른 `word`를 찾아 내는 것이다. 나는 `isDiffOneChar()` 메소드를 생성하여 해결했다.

```java
public boolean isDiffOneChar(String begin, String target) {
    int diffCount = 0;
    for (int i=0; i<begin.length(); i++)
        if (begin.charAt(i) != (target.charAt(i))) diffCount++;

    return diffCount == 1;
}
```

핵심 DFS 코드는 다음과 같다.

```java
for (int i=0; i<words.length; i++) {
    if (isDiffOneChar(begin, words[i]) && !visited[i]) {
        visited[i] = true;
        DFS(words, words[i], target, count + 1, visited);
        visited[i] = false;
    }
}
```

`begin`으로 주어진 단어와 word[] 배열의 요소 중 글자가 하나만 다른 요소를 찾는다. 그리고 해당 요소를 begin으로 취급하여 변환 할 수 있는 단어가 있는지 재귀하여 조회한다.

단어가 최대 50개까지 들어올 수 있기 때문에 여유있게 `result` 값을 60으로 설정해두고, 단어 변환을 `target` 까지 완료 했을 떄, 횟수를 체크하여 `result`에 저장한다. 이 때 기존 `result` 값보다 작은 값만 `result`에 저장한다. (최소값 저장)