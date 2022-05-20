package lv1;

import java.util.ArrayList;

public class ChangeInt {
  public static class Solution {
    public int[] solution( long n ) {
      int[] answer;

      ArrayList<Long> list = new ArrayList<>();

      long temp = 0;

      while( true ) {
        temp = n % 10;

        temp = ( int ) temp;

        list.add( temp );
        if( n < 10 ) {
          break;
        }

        n = n / 10;
      }

      answer = new int[list.size()];

      for( int i = 0; i < list.size(); i++ ) {
        answer[i] = list.get( i ).intValue();
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] result = {};
    long n = 12345;

    result = solution.solution( n );

    for( long i : result ) {
      System.out.print( i + " " );
    }
  }
}
