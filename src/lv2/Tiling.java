package lv2;

public class Tiling {
  public static class Solution {
    static int[] d = new int[1001];

    public int dp( int n ) {
      if( n == 1 ) {
        return 1;
      }
      if( n == 2 ) {
        return 2;
      }
      if( d[n] != 0 ) {
        return d[n];
      }
      return d[n] = ( dp( n - 1 ) + dp( n - 2 ) ) % 10007;
    }

    public int solution( int n ) {
//      int answer = 0;
//
//      answer = dp( n );
//
//      return answer;
      int[] temp = new int[n];
      temp[0] = 1;
      temp[1] = 2;

      for( int i = 2; i < n; i++ ) {
        temp[i] = ( temp[i - 1] + temp[i - 2] ) % 10000007;
      }

      return temp[n - 1];
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 4;
    int result = solution.solution( n );

    System.out.println( "RESULT = " + result );
  }
}
