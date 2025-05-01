## 모음 사전

|풀이 사이트|문제이름|난이도|
|:---:|:---:|:---:|
| [프로그래머스](https://school.programmers.co.kr/learn/courses/30/lessons/84512)|모음 사전|Lv.2|


### 풀이
재귀 함수를 통해 풀 수 있었다. 모든 조건을 탐색해서 푸는 문제다. 문자의 규칙을 보니 단어의 길이가 `5`가 될 때까지 끝에 `A`를 추가시킨다. 그리고 단어의 길이가 `5`가 되면 가장 끝에 있는 문자를 다음 문자로 변환한다. 문자 순서는 다음과 같다.
```
A -> E -> I -> O -> U
```

그리고 마침내, 끝 문자가 `U`에 도달하면 앞 문자를 다음 문자로 변환한다. 그리고 맨 뒤에 문자는 사라진다.

```
AAAAU -> AAAE
```

만약에 다음과 같은 경우도 있다.

```
AUUUU -> E
```

여기서 가장 끝 문자가 다음으로 변경되면 index - 1 문자도 U 이기 때문에 계속해서 index - 1을 하다가 마침내 A를 만나고 A -> E로 변환한다. 그리고 변환된 문자 이외의 문자들은 모두 소멸된다. 이 때 StringBuffer.deleteCharAt(index)를 통해 삭제할 수 있다. index에는 `현재 문자 길이 - 1`로 설정해주면 된다. 핵심 코드는 다음과 같다.

```java
public change(int index) {
    if (tempWord.charAt(index) == 'U') {
        change();
        tempWord.deleteCharAt(tempWord.length() - 1);
    } else {
        tempWord.setCharAt(index, up(tempWord.charAt(index)));
    }
}

public char up(char a) {
    if (a == 'A') return 'E';
    if (a == 'E') return 'I';
    if (a == 'I') return 'O';
    return 'U';
}
```

`up()` 함수는 단순히 Character를 보고, 다움 문자로 변환 시키는 함수이고, change 함수에 들어온 index가 tempWord.charAt(index) == 'U' 일 때에는 이전 index `(index-1)` 를 파라미타로 하여 함수를 재귀적으로 호출한다. 그리고 마지막 문자를 삭제한다. 

