package lv2;

public class NumberShow {
  public static class Solution {
    public int solution( int n ) {
      int answer = 0;
      int sum    = 0;

//      for( int i = 1 ; i <= n; i++ ) {
//        for( int j = i; j <= n; j++ ) {
//          sum = sum + j;
//          System.out.println( "SUM = " + sum );
//          if( sum == n ) {
//            answer++;
//            break;
//          }
//        }
//        sum = 0;
//      }
      //1번
      int i = 0;
      while( i <= n ) {
        i++;
        for( int j = i; j <= n; j++ ) {
          sum = sum + j;
          System.out.println( "SUM = " + sum );
          if( sum == n ) {
            answer++;
            break;
          } else if( sum > n ) {
            break;
          }
        }
        sum = 0;
      }

      //2번  주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리
      for (int k = 1; k <= n; k += 2) {
        if (n % k == 0) {
          answer++;
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 15;

    int result = solution.solution( n );
    System.out.println( "RESULT = " + result );
  }
}
