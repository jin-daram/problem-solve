## 수 찾기

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
|[백준 1920](https://www.acmicpc.net/problem/1920)|수 찾기|실버 4|

### 풀이

이분 탐색을 통해 `left <= right` 조건을 만족할 때 까지 `target` 을 찾으면 `1`을 출력하고 만약 찾지 못하면 `find` boolean 변수를 통해 `0`을 출력하도록 풀이

```java
for (int i=0; i<M; i++) {
    boolean find = false;
    int left = 0, right = N - 1, target = targets[i];

            
    while (left <= right) {
        int mid = (left + right) / 2;

        if (numbers[mid] == target) {
            System.out.println("1");
            find = true;
            break;
        }
        else if (numbers[mid] < target) left = ++mid;
        else right = --mid;
    }

    if (!find) System.out.println("0");
}
```

