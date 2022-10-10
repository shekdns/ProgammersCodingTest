package lv2;

import java.util.Arrays;
import java.util.Collections;

public class Hindex {
  public static class Solution {
    public int solution( int[] citations ) {
      int answer = 0;
      boolean flag = false;
      Integer[] array = Arrays.stream( citations ).boxed().toArray( Integer[]::new);
      Arrays.sort( array, Collections.reverseOrder() );

      for( int i = 0; i < array.length; i++ ) {
        if( i + 1 >= array[i] ) {
          answer = i;
          flag = true;
          break;
        }
      }

      if( flag == false ) {
        System.out.println( "AA = " + array.length );
        answer = array.length;
      }

      return answer;
    }
  }
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] citations   = { 3, 0, 6, 1, 5 };
    //int[] citations   = { 10, 10, 10, 10, 10 };
    //int[] citations   = { 0,0,0,0,0 };

    int result = solution.solution( citations );
    System.out.println( "RESULT = " + result );
  }

}
