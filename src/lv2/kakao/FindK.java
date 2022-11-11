package lv2.kakao;
//2022 KAKAO BLIND RECRUITMENT k진수에서 소수 개수 구하기
public class FindK {
  public static class Solution {
    public int solution( int n, int k ) {
      int answer = -1;

      StringBuilder sb = new StringBuilder();
      while( true ) {
        int t = n % k;
        sb.append( String.valueOf(t) );

        if( n < k ) {
          break;
        }

        n = n / k;
      }

      String temp = sb.reverse().toString();
      // 소수가 되는 조건
      // 1. 0P0 처럼 소수 양쪽에 0이 있는 경우
      // 2. P0 처럼 소수 오른쪽에만 0이 있고 왼쪽에는 없는 경우
      // 3. 0P 처럼 소수 왼쪽에만 0이 있고 오른쪽에는 없는 경우
      // 4. P처럼 소수 양쪽에 아무것도 없는 경우
      // 예외 : 101은 소수가 아님
      for( int i = 0; i < temp.length(); i++ ) {

      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n1 = 437674;
    int k1 = 3;
    int n2 = 110011;
    int k2 = 10;

    int result = solution.solution( n1, k1 );

    System.out.println( "RESULT = " + result );
  }
}
