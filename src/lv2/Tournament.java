package lv2;

public class Tournament {
  public static class Solution {
    public int solution( int n, int a, int b ) {
      int answer = 1;

      for( int i = 2; i <= n; i = 2 * i ) {

        if( a % 2 != 0 ) {
          a++;
        }
        if( b % 2 != 0 ) {
          b++;
        }

        a = a / 2;
        b = b / 2;
        System.out.println( "A = " + a + "  B = " + b );
        answer++;
        if( a > b ) {
          if( a % 2 == 0 ) {
            if( a - 1 == b ) {
              break;
            }
          } else {
            if( a + 1 == b ) {
              break;
            }
          }
        } else {
          if( b % 2 == 0 ) {
            if( b - 1 == a ) {
              break;
            }
          } else {
            if( b + 1 == a ) {
              break;
            }
          }
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 8;
    int a = 4;
    int b = 7;
    int result = solution.solution( n, a, b );

    System.out.println( "RESULT = " + result );
  }
}
