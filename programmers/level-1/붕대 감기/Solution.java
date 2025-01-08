package programmers.level_1.붕대_감기;

/**
 * 프로그래머스 (Level 1) : 붕대 감기
 */

class Solution {

  public int solution(int[] bandage, int health, int[][] attacks) {
    int answer = health; // 현재 체력

    int t = bandage[0];  // 시전 시간
    int x = bandage[1];  // 초당 회복량
    int y = bandage[2];  // 추가 회복량

    int count = 0;       // 연속 성공 횟수

    int lastAttack = attacks[attacks.length - 1][0]; // 마지막 공격 시간

    int index = 0;
    int attacksIndex = 0;

    while (index <= lastAttack) {

      // 공격을 받았을 경우
      if (index == attacks[attacksIndex][0]) {
        count = 0;
        answer -= attacks[attacksIndex][1];
        attacksIndex += 1;

        // 현재 체력이 0 이하일 경우
        if (answer <= 0) {
          answer = -1;
          break;
        }
      }
      // 공격을 받지 않았을 경우
      else {
        count += 1;
        answer += x;

        // 연속으로 붕대 감기에 성공했을 경우
        if (count == t) {
          count = 0;
          answer += y;
        }

        // 현재 체력이 최대 체력을 초과했을 경우
        if (answer > health) {
          answer = health;
        }
      }

      index += 1;
    }

    return answer;
  }
}
