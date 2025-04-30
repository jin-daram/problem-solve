## 불량 사용자
|풀이 사이트|문제 이름|난이도|비고|
|:---:|:---:|:---:|:---:|
|[프로그래머스](https://school.programmers.co.kr/learn/courses/30/lessons/64064)|불량 사용자|Lv.3|2019 카카오 개발자 겨울 인턴십|

### 풀이
DFS로 푼 문제이다. 제재 아이디는 무조건 유저 아이디를 표현하는 것이기 때문에, 불량 사용자 목록은 무조건 제재 아이디 만큼의 속성 개수를 가진다.

```
응모자 아이디 : ["frodo", "fradi", "crodo", "abc123", "frodoc"]
제재 아이디 : ["fr*d*", "abc1**"]
```

일 때, 불량 사용자는 반드시 2명씩 구성된다. 

DFS에서 다음과 같은 코드에서 사용할 수 있다.

```java
for (int i=0; i<userId.size(); i++) {
    if (compare(userId.get(i), bannedId.get(0))) {
        ...
    }
}
```

`bannedId`의 `0번째 요소`로 조회 가능한 이유가 반드시 `userId` 안에 매칭되는 것이 존재하기 때문이다. 

그렇게 매칭되면 다음 DFS 함수에 이전에 매칭된 요소들은 제외한 `userId`와 `bannedId`를 제거해주어야 한다. 

```java
public void DFS(List<String> userId, List<String> bannedId, List<String> path) {
    if (bannedId.isEmpty()) {
        ways.add(path);
        return;
    }

    for (int i=0; i<userId.size(); i++) {
        + String newUser = userId.get(i);
        + String newbannedId = bannedId.get(0);
        if (compare(userId.get(i), bannedId.get(0))) {
            + List<String> newUserList = new ArrayList<>(userId);
            + List<String> newBannedIdList = new ArrayList<>(bannedId);
            + Set<String> newPath = new HashSet(path);

            + newUserList.remove(i);
            + newBannedIdList.remove(0);
            + newPath.add(newUser);

            dfs(newUserList, newBannedIdList, newPath);        
        }
}
}
```

Set 자료구조를 사용하였기 때문에 중복되는 요소들은 자동으로 제거된다.