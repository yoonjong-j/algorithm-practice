# 동영상 재생기

[[PCCP 기출문제] 1번 / 동영상 재생기](https://school.programmers.co.kr/learn/courses/30/lessons/340213)

## 제출 코드

[Solution.java](/programmers/level-1/동영상%20재생기/Solution.java)

## 제출 결과

### 테스트

![테스트](/programmers/level-1/동영상%20재생기/img/result-1.JPG)

### 최종 제출

![최종 제출](/programmers/level-1/동영상%20재생기/img/result-2.JPG)

## 문제 풀이

### 동영상 재생기의 3가지 기능

- 10초 전으로 이동
- 10초 후로 이동
- 오프닝 건너뛰기

### 주어진 Parameters

- `video_len`
  - String 타입
  - 동영상의 길이
  - `mm:ss` 형식 (예: 15:02)
- `pos`
  - String 타입
  - 기능을 수행하기 전 상태인 현재 위치
  - `mm:ss` 형식 (예: 15:02)
- `op_start`
  - String 타입
  - 오프닝 시작 시간
  - `mm:ss` 형식 (예: 15:02)
- `op_end`
  - String 타입
  - 오프닝 끝나는 시간
  - `mm:ss` 형식 (예: 15:02)
- `commands`
  - String 타입의 배열
  - 기능 수행을 위한 명령어를 담고 있음
    - `prev`: 10초 전으로 이동
    - `next`: 10초 후로 이동

### 고려해야하는 조건

- `00:00 <= pos < 00:10`
  - 현재 위치가 동영상이 시작한지 10초 미만일 경우
  - pos → 동영상의 처음 위치인 `00:00`으로 설정
- `op_start <= pos <= op_end`
  - 현재 위치가 오프닝 구간일 경우
  - pos → 오프닝이 끝나는 시간인 `op_end`로 설정 (= 오프닝 건너뛰기)
- `video_len - 10 < pos <= video_len`
  - 동영상의 남은 시간이 10초 미만일 경우에 `next` 명령어가 주어졌을 때
  - pos → 동영상이 끝나는 시간, 즉, 동영상의 길이인 `video_len`으로 설정

#### 주의 사항

- `prev`, `next` 명령어 모두 오프닝 건너뛰기 기능을 지원해야함
