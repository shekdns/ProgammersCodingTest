package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MakeMin {
  public static class Solution {
    public int solution( int[] A, int[] B ) {
      int answer = 0;
      Integer[] BB = new Integer[B.length];
      for( int i = 0; i < B.length; i++ ) {
        BB[i] = B[i];
      }

      Arrays.sort( A );
      Arrays.sort( BB, Collections.reverseOrder() );

      for( int i = 0; i < A.length; i++ ) {
        answer += ( A[i] * BB[i] );
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] a = { 1, 4, 2 };
    int[] b = { 5, 4, 4 };

    int result = solution.solution( a, b );
    System.out.println( "RESULT = " + result );
  }
}
