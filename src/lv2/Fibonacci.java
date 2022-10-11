package lv2;

import java.math.BigInteger;

public class Fibonacci {
  public static class Solution {
    public int fibo( int n ) {
      if( n<= 1 ) {
        return n;
      } else {
        return fibo(n-2) + fibo(n-1);
      }
    }
    public int solution( int n ) {
      int answer = 0;

      long[] temp = new long[n];
      temp[0] = 1;
      temp[1] = 1;

      for( int i = 2; i < n; i++ ) {
        temp[i] = (temp[i - 2] + temp[i - 1])  % 1234567;
      }
//      BigInteger a = new BigInteger( String.valueOf( answer ) );
//
//      for( int i = 1; i <= n; i++ ) {
//        a = BigInteger.valueOf(fibo(i));
//        System.out.println( "I = " + i + " A = " + answer );
//      }

      return Integer.parseInt( String.valueOf(temp[n-1]) );
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 3;

    int result = solution.solution( n );

    System.out.println( "RESULT = " + result );
  }
}
