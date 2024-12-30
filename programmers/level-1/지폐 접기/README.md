# 지폐 접기

[[PCCE 기출문제] 9번 / 지폐 접기](https://school.programmers.co.kr/learn/courses/30/lessons/340199)

## 제출 코드

[Solution.java](/programmers/level-1/지폐%20접기/Solution.java)

## 제출 결과

### 테스트

![테스트](/programmers/level-1/지폐%20접기/img/result-1.JPG)

### 최종 제출

![최종 제출](/programmers/level-1/지폐%20접기/img/result-2.JPG)

## 문제 풀이

- 문제 설명에 작성된 `지폐를 지갑에 넣기 위해 접어야 하는 최소 횟수를 구하는 과정`을 따를 것

```
1. 지폐를 접은 횟수를 저장할 정수 변수 answer를 만들고 0을 저장합니다.
2. 반복문을 이용해 bill의 작은 값이 wallet의 작은 값 보다 크거나 bill의 큰 값이 wallet의 큰 값 보다 큰 동안 아래 과정을 반복합니다.
    2-1. bill[0]이 bill[1]보다 크다면
        bill[0]을 2로 나누고 나머지는 버립니다.
    2-2. 그렇지 않다면
        bill[1]을 2로 나누고 나머지는 버립니다.
    2-3. answer을 1 증가시킵니다.
3. answer을 return합니다.
```
