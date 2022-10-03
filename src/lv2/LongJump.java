package lv2;

import java.math.BigInteger;

public class LongJump {
  public static class Solution {
    public long solution( int n ) {
      long answer = 0;

      if( n == 1 ) {
        return 1;
      } else if( n == 2 ) {
        return 2;
      } else {
        long[] array = new long[n];
        array[0] = 1;
        array[1] = 2;

        for (int i = 2; i < n; i++) {
          array[i] = (array[i - 2] + array[i - 1])  % 1234567;
          System.out.println( array[i-2] + "  " + array[i-1] );
        }

        answer = array[n-1];

        return answer;
      }
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 2000;

    long result = solution.solution( n );
    System.out.println( "RESULT = " + result );
  }
}
