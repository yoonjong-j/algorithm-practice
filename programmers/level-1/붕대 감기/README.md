# 붕대 감기

[[PCCP 기출문제] 1번 / 붕대 감기](https://school.programmers.co.kr/learn/courses/30/lessons/250137)

## 제출 코드

[Solution.java](/programmers/level-1/붕대%20감기/Solution.java)

## 제출 결과

### 테스트

![테스트](/programmers/level-1/붕대%20감기/img/result-1.JPG)

### 최종 제출

![최종 제출](/programmers/level-1/붕대%20감기/img/result-2.JPG)

## 문제 풀이

### 주어진 Parameters

- `bandage`
  - int 타입의 1차원 배열
  - 기술의 `시전 시간`, `1초당 회복량`, `추가 회복량`을 담고 있음
    - `t`: `시전 시간`
    - `x`: `1초당 회복량`
    - `y`: `추가 회복량`
- `health`
  - int 타입
  - 최대 체력
- `attacks`
  - int 타입의 2차원 배열
  - 몬스터의 `공격 시간`, `피해량`을 담고 있음

### 고려해야하는 조건

- 현재 체력은 최대 체력을 넘어설 수 없음
- 몬스터의 공격을 받으면 공격이 끝날 때까지 체력 회복 불가능
- 몬스터의 공격을 받으면 피해량만큼 현재 체력이 줄어듬
- 현재 체력이 0 이하가 되면 -1을 return
