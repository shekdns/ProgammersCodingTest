package lv2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SafeBoat {
  public static class Solution {
    public int solution( int[] people, int limit ) {
      int answer = 0;

      Arrays.sort( people );
      Deque<Integer> deque = new LinkedList<>();

      for( int p : people ) {
        deque.add( p );
      }

      int temp = 0;

      while( !deque.isEmpty() ) {
        temp = deque.pollLast(); //80을 제거 그다음 70을 제거
        System.out.println( "TEMP = " + temp );
        answer++;
        if( deque.isEmpty() ) {
          break;
        }
        if( temp + deque.getFirst() <= limit ) {
          deque.pollFirst();
          continue;
        }
        if( temp + deque.getLast() <= limit ) {
          deque.pollFirst();
        }
      }
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    //int[] people = { 70, 50, 80, 50 };
    int[] people = { 70, 80, 50 };
    int limit = 100;

    int result = solution.solution( people, limit );
    System.out.println( "RESULT = " + result );
  }
}
