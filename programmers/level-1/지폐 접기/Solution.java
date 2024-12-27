package programmers.level_1.지폐_접기;

/**
 * 프로그래머스 (Level 1) : 지폐 접기
 */

class Solution {

  public int solution(int[] wallet, int[] bill) {
    int answer = 0;
    boolean valid = compare(wallet, bill);

    while (valid == false) {
      if (bill[0] > bill[1]) {
        bill[0] = bill[0] / 2;
      } else {
        bill[1] = bill[1] / 2;
      }
      answer = answer + 1;
      valid = compare(wallet, bill);
    }

    return answer;
  }

  private boolean compare(int[] wallet, int[] bill) {
    int maxWallet = Math.max(wallet[0], wallet[1]);
    int minWallet = Math.min(wallet[0], wallet[1]);
    int maxBill = Math.max(bill[0], bill[1]);
    int minBill = Math.min(bill[0], bill[1]);
    boolean valid = true;

    if (maxBill > maxWallet || minBill > minWallet) {
      valid = false;
    }

    return valid;
  }
}
