package programmers.level_1.동영상_재생기;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * 프로그래머스 (Level 1) : 동영상 재생기
 */

class Solution {

  public String solution(String video_len, String pos, String op_start, String op_end,
      String[] commands) {
    String answer = "";
    LocalTime videoLen; // 동영상 길이
    LocalTime position; // 현재 위치
    LocalTime opStart;  // 오프닝 시작 시각
    LocalTime opEnd;    // 오프닝 종료 시각

    try {
      videoLen = LocalTime.parse("00:" + video_len);
      position = LocalTime.parse("00:" + pos);
      opStart = LocalTime.parse("00:" + op_start);
      opEnd = LocalTime.parse("00:" + op_end);

      for (String command : commands) {
        // 현재 위치가 오프닝 구간일 경우
        if (!position.isBefore(opStart) && position.isBefore(opEnd)) {
          position = opEnd;
        }

        // 10초 뒤로 이동
        if (command.equals("prev")) {
          // 현재 위치가 00:00 - 00:10 사이일 경우
          if (!position.isBefore(LocalTime.parse("00:00:00")) &&
              position.isBefore(LocalTime.parse("00:00:10"))) {
            position = LocalTime.parse("00:00:00");
          }

          // 현재 위치가 00:00일 경우
          else if (position.equals(LocalTime.parse("00:00:00")) ||
              position.isBefore(LocalTime.parse("00:00:00"))) {
            position = LocalTime.parse("00:00:00");
          } else {
            position = position.minusSeconds(10);

            // 10초 전으로 이동한 시각이 오프닝 구간일 경우
            if (!position.isBefore(opStart) && position.isBefore(opEnd)) {
              position = opEnd;
            }
          }
        }

        // 10초 후로 이동
        else if (command.equals("next")) {
          // 동영상 남은 시간이 10초 미만일 경우
          if (position.plusSeconds(10).isAfter(videoLen)) {
            position = videoLen;
          }

          // 현재 위치에서 10초 후가 오프닝 구간일 경우
          else if (!position.plusSeconds(10).isBefore(opStart) &&
              position.plusSeconds(10).isBefore(opEnd)) {
            position = opEnd;
          } else {
            position = position.plusSeconds(10);
          }
        }
      }

      answer = position.format(DateTimeFormatter.ofPattern("mm:ss"));
    } catch (DateTimeParseException e) {
      System.out.println("옳바르지 않은 시간 형식: " + e.getMessage());
    }

    return answer;
  }
}
