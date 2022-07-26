package lv2;

import java.util.*;

public class Printer {
  public static class Solution {

    public int solution( int[] priorities, int location ) {
      int answer = 0;

      PriorityQueue<Integer> pqueqe = new PriorityQueue<>( Comparator.reverseOrder() );

      for( int i = 0; i < priorities.length; i++ ) {
        pqueqe.add( priorities[i] );  // add 는 추
      }

      System.out.println( "PPP = " + pqueqe );

      while( !pqueqe.isEmpty() ) {
        int b = 0;
        System.out.println( pqueqe.peek() );
        for( int i = 0; i < priorities.length; i++ ) {
          System.out.println( i + " || " + priorities[i] + "|| " + pqueqe.peek() );
          if( priorities[i] == pqueqe.peek() ) {
            System.out.println( answer );
            if( i == location ) {
              answer++;
              b = 1;
              break;
            }
            pqueqe.poll();
            answer++;
          }
        }
        if( b == 1 ) {
          break;
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] priorities = { 2, 1, 3, 2 }; // A B C D -> C D A B
    int[] p2 = { 1,1,9,1,1,1 };
    int location = 0;

    int result = solution.solution( p2, location );  //RESULT = 5

    System.out.println( "RESULT = " + result );
  }
}
