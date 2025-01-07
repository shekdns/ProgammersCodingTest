package lv1.pcc;

/*
*
1. 지폐를 접은 횟수를 저장할 정수 변수 answer를 만들고 0을 저장합니다.
2. 반복문을 이용해 bill의 작은 값이 wallet의 작은 값 보다 크거나 bill의 큰 값이 wallet의 큰 값 보다 큰 동안 아래 과정을 반복합니다.
    2-1. bill[0]이 bill[1]보다 크다면
        bill[0]을 2로 나누고 나머지는 버립니다.
    2-2. 그렇지 않다면
        bill[1]을 2로 나누고 나머지는 버립니다.
    2-3. answer을 1 증가시킵니다.
3. answer을 return합니다.
*
* */

public class BillFold {
  public static class Solution {
    public int solution(int[] wallet, int[] bill) {
      int answer = 0;

      int wallect_row = wallet[0]; //30
      int wallect_col = wallet[1]; //15
      int bill_row = bill[0]; // 26
      int bill_col = bill[1]; // 17

      while( true ) {
        if( bill_row <= wallect_row && bill_col <= wallect_col ) {
          break;
        }
        if( bill_col <= wallect_row && bill_row <= wallect_col ) {
          break;
        }

        if( bill_row > bill_col ) {
          bill_row /= 2;
        } else {
          bill_col /= 2;
        }

        answer++;
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] wallet1 = { 30, 15 };
    int[] bill1   = { 26, 17 };

    int[] wallet2 = { 50, 50 };
    int[] bill2   = { 100, 241 };

    int result = solution.solution( wallet2, bill2 );
    System.out.println( "RESULT = " + result );
  }
}
